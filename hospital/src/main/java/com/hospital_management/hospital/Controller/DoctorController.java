package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.DoctorDTO;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public BaseResponse addinfo(@RequestBody DoctorDTO doctorDTO) {
        return userService.addinfo(doctorDTO);
    }
}
