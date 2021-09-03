package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.PatientDTO;
import com.hospital_management.hospital.Entity.Patient;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/patient")
@RestController

public class PatientController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public BaseResponse addPatientInfo(@RequestBody PatientDTO patientDTO) {
        return userService.addPatientInfo(patientDTO);
    }

    @GetMapping("/patientId/{id}")
    public Patient getPatientInfo(@PathVariable int id){
        return userService.getPatientById(id);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse  getdeleteInfo(@PathVariable int id){
        return userService.deletePatientById(id);
    }

    @PutMapping("update")
    public BaseResponse putupdateInfo(@RequestBody PatientDTO patientDTO){
        return userService.updatePatientById(patientDTO);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ApiResponse<Page<Patient>> patientWithPaginationInfo(@PathVariable int offset, @PathVariable int pageSize){
        Page<Patient> Pagination = userService.findPatientWithPagination(offset, pageSize);
        return new ApiResponse<>(Pagination.getSize(),Pagination);
    }
}


