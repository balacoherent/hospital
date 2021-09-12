package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponseRep;
import com.hospital_management.hospital.DTO.TokenDTO;
import com.hospital_management.hospital.DTO.UserDTO;
import com.hospital_management.hospital.Entity.User;
import com.hospital_management.hospital.Service.UserService;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")

    public BaseResponseRep<User> addInfo(@RequestBody UserDTO userDTO)   {
        BaseResponseRep<User> baseResponseRep=null;
        baseResponseRep = BaseResponseRep.<User>builder().Data(userService.addInfo(userDTO)).build();
        return baseResponseRep;
    }

    @GetMapping("/getAll")
    @Authorization(value = "Bearer")
    public BaseResponseRep <List<User>> listAll(){
        BaseResponseRep<List<User>> baseResponseRep= null;
        baseResponseRep = BaseResponseRep.<List<User>>builder().Data(userService.listall()).build();
        return baseResponseRep;
    }

    @GetMapping("/userid/{id}")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>> getUserById(@PathVariable Integer id){
        BaseResponseRep<Optional<User>> baseResponseRep= null;
        baseResponseRep = BaseResponseRep.<Optional<User>>builder().Data(userService.getUserbyId(id)).build();
        return baseResponseRep;
    }

    @PutMapping("/deleteSoft")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>> deletesoft(@RequestBody UserDTO userDTO){
        BaseResponseRep<Optional<User>> baseResponseRep= null;
        baseResponseRep = BaseResponseRep.<Optional<User>>builder().Data(userService.deletesoft(userDTO)).build();
        return baseResponseRep;

    }

    @PutMapping("/update")
    @Authorization(value = "Bearer")
    public BaseResponseRep<Optional<User>> updateInfo(@RequestBody UserDTO userDTO){
        BaseResponseRep<Optional<User>> baseResponseRep= null;
        baseResponseRep = BaseResponseRep.<Optional<User>>builder().Data(userService.updatebyId(userDTO)).build();
        return baseResponseRep;
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{userName}")
    @Authorization(value = "Bearer")
    private ApiResponse<User> getUserWithPagination(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String userName){
        return userService.GetUserWithPagination(offset, pageSize, userName);
    }
    @GetMapping("/login")
    public BaseResponseRep jwt(@RequestBody TokenDTO tokenDTO) {
        BaseResponseRep baseResponseRep=null;
        baseResponseRep=BaseResponseRep.builder().Data(userService.Jwt(tokenDTO)).build();
        return baseResponseRep;
    }
}
