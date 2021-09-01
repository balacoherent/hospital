package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.AppointmentDTO;
import com.hospital_management.hospital.DTO.UserDTO;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public BaseResponse addinfo(@RequestBody AppointmentDTO appointmentDTO) {
        return userService.addinfo(appointmentDTO);
    }
}
