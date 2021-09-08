package com.hospital_management.hospital.Service;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.DTO.TokenDTO;
import com.hospital_management.hospital.DTO.UserDTO;
import com.hospital_management.hospital.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    User addInfo(UserDTO userDTO);

    Optional<User> getUserbyId(Integer id);

    List<User> listall();

    Optional<User> deletesoft(UserDTO userDTO);

    Optional<User> updatebyId(UserDTO userDTO);

    ApiResponse<User> GetUserWithPagination(int offset, int pageSize, String userName);

    Object Jwt(TokenDTO tokenDTO);
}
