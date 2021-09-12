package com.hospital_management.hospital.Service;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.DTO.*;
import com.hospital_management.hospital.Entity.*;
import com.hospital_management.hospital.Repository.*;

import com.hospital_management.hospital.ServiceInterface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.hospital_management.hospital.Util.JwtUtil.generateToken;


@Service
@Transactional

public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addInfo(UserDTO userDTO) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(bcrypt.encode(userDTO.getPassword()));
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
        Optional<User> users = userRepository.findByuserName(tokenDTO.getUserName());
        try {
            if (users.isPresent()) {
                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                boolean chek = bcrypt.matches(tokenDTO.getPassword(), users.get().getPassword());
                if (chek == true) {
                    String jwtt = generateToken(users.get().getUserId(), "üser", users.get().getUserName());
                    tokenDTO.setToken(jwtt);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenDTO;
    }


    public UserDetails loadByUserId(String userId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByuserName(userId);
        Optional<User> opt = Optional.ofNullable(user).orElseThrow(
                        () -> new UsernameNotFoundException("userid not found"))
                .map(UserDetailImp::new);
        if (opt.isPresent()) {
            return (UserDetails) opt.get();
        }
        return null;

    }
}
