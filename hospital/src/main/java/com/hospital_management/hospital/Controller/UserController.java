package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
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
    public List<User> list(){
        return userService.listAll();
    }

    @GetMapping("/userid/{id}")
    public BaseResponse<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PutMapping("/deleteSoft")
    public BaseResponse  deleteSoft(@RequestBody UserDTO userDTO){
        return userService.deleteSoft(userDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateInfo(@RequestBody UserDTO userDTO){
        return userService.updateById(userDTO);
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{userName}")
    private ApiResponse<User> getUserWithPagination(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String userName){
        return userService.getUserWithPagination(offset, pageSize, userName);
    }
}
