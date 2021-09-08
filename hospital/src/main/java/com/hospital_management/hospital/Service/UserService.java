package com.hospital_management.hospital.Service;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.*;
import com.hospital_management.hospital.Entity.*;
import com.hospital_management.hospital.Repository.*;
import com.hospital_management.hospital.Util.UserGenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.hospital_management.hospital.Util.UserGenerateToken.userGenerateToken;

@Service
@Transactional

public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
     public User addInfo(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserbyId(Integer id) {
        Optional<User> user=userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> listall() {
        List<User> obj =userRepository.findAll();
        return obj;
    }

    @Override
    public Optional<User>  deletesoft(UserDTO userDTO) {
        Optional<User> existUser = userRepository.findByUserId(userDTO.getUserId());
        if (existUser.isPresent())
        {
            existUser.get().setIsDelete(1);
        }
        else
        {
            throw new RuntimeException("data not found");
        }
        userRepository.save(existUser.get());
        return existUser;
    }

    @Override
    public Optional<User> updatebyId(UserDTO userDTO) {
        Optional<User> existUser = userRepository.findById(userDTO.getUserId());
        if (existUser.isPresent())
        {
            existUser.get().setUserId(userDTO.getUserId());
            existUser.get().setUserName(userDTO.getUserName());
            existUser.get().setPassword(userDTO.getPassword());
        }
        else
        {
            throw new RuntimeException("data not found");
        }
        userRepository.save(existUser.get());

        return existUser;
    }

    @Override
    public ApiResponse<User> GetUserWithPagination(int offset, int pageSize, String userName) {
        Pageable paging=PageRequest.of(offset,pageSize);
        Page<User> Users = userRepository.searchAllByUserNameLike("%" + userName + "%", paging);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setResponse(Users);
        apiResponse.setRecordCount(Users.getTotalPages());
        return apiResponse;
    }
    @Override
    public TokenDTO Jwt(TokenDTO tokenDTO) {
        Optional<User> users = userRepository.findByNameAndPassword(tokenDTO.getName(), tokenDTO.getPassword());
        try {
            if (users.isPresent() ) {
                String jwtt = userGenerateToken(users.get().getUserName(),"üser",users.get().getPassword());
                tokenDTO.setToken(jwtt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenDTO;
    }
}
