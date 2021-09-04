package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.DiseaseDTO;
import com.hospital_management.hospital.Entity.Disease;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/disease")
@RestController
public class DiseaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/addDisease")
    public BaseResponse addDiseaseInfo(@RequestBody DiseaseDTO diseaseDTO) {
        return userService.addDiseaseInfo(diseaseDTO);
    }

    @GetMapping("/getAll")
    public List<Disease> list(){
        return userService.listAllDisease();
    }

    @PutMapping("/deleteSoft")
    public BaseResponse  deleteSoft(@RequestBody DiseaseDTO diseaseDTO){
        return userService.deleteSoftDisease(diseaseDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateDiseaseById(@RequestBody DiseaseDTO diseaseDTO){
        return userService.updateDiseaseById(diseaseDTO);
    }

}
