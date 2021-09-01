package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.UserDTO;
import com.hospital_management.hospital.Entity.User;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public BaseResponse addinfo(@RequestBody UserDTO userDTO) {
        return userService.addinfo(userDTO);
    }
    @GetMapping("/getAll")
    public List<User> list() {
        return userService.listAll();
    }


}
