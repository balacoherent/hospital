package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.UserDTO;
import com.hospital_management.hospital.Entity.User;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public User findUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse  deleteById(@PathVariable int id){
        return userService.deleteById(id);
    }

    @PutMapping("update")
    public BaseResponse updateInfo(@RequestBody UserDTO userDTO){
        return userService.updateById(userDTO);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ApiResponse<Page<User>> findUserWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<User> Pagination = userService.findUserWithPagination(offset, pageSize);
        return new ApiResponse<>(Pagination.getSize(),Pagination);
    }
}
