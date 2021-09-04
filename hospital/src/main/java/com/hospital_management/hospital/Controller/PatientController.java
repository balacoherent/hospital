package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.PatientDTO;
import com.hospital_management.hospital.Entity.Patient;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/patient")
@RestController
public class PatientController {
    @Autowired
    private UserService userService;

    @PostMapping("/addPatient")
    public BaseResponse addPatientInfo(@RequestBody PatientDTO patientDTO) {
        return userService.addPatientInfo(patientDTO);
    }

    @GetMapping("/patientId/{id}")
    public BaseResponse<Patient> getPatientById(@PathVariable Integer id){
        return userService.getPatientById(id);
    }

    @PutMapping("/deleteSoft")
    public BaseResponse  deleteSoft(@RequestBody PatientDTO patientDTO){
        return userService.deleteSoftPatient(patientDTO);
    }

    @PutMapping("/update")
    public BaseResponse putupdateInfo(@RequestBody PatientDTO patientDTO){
        return userService.updatePatientById(patientDTO);
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{patientName}")
    private ApiResponse<Patient> getPatientWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String patientName){
        return userService.getPatientWithPagination(offset, pageSize, patientName);
    }
}


