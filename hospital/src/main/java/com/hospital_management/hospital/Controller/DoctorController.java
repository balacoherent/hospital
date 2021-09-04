package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.DoctorDTO;
import com.hospital_management.hospital.Entity.Doctor;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    private UserService userService;

    @PostMapping("/addDoctor")
    public BaseResponse addDoctorInfo(@RequestBody DoctorDTO doctorDTO) {
        return userService.addDoctorInfo(doctorDTO);
    }

    @GetMapping("/doctorId/{id}")
    public BaseResponse<Doctor> getDoctorById(@PathVariable int id){
        return userService.getDoctorById(id);
    }

    @PutMapping("/deleteSoft")
    public BaseResponse  deleteSoft(@RequestBody DoctorDTO doctorDTO){
        return userService.deleteSoftDoctor(doctorDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateInfo(@RequestBody DoctorDTO doctorDTO){
        return userService.updateDoctorById(doctorDTO);
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{doctorName}")
    private ApiResponse<Doctor> getDoctorWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String doctorName){
        return userService.getDoctorWithPagination(offset, pageSize, doctorName);
    }
}

