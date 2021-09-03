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

    @PostMapping("/add")
    public BaseResponse addDiseaseInfo(@RequestBody DiseaseDTO diseaseDTO) {
        return userService.addDiseaseInfo(diseaseDTO);
    }

    @GetMapping("/getAll")
    public List<Disease> list(){
        return userService.listAllDisease();
    }

    @DeleteMapping("/deleteId/{id}")
    public BaseResponse  deleteInfo(@PathVariable int id){
        return userService.deleteDiseaseById(id);
    }

    @PutMapping("update")
    public BaseResponse updateInfo(@RequestBody DiseaseDTO diseaseDTO){
        return userService.updateDiseaseById(diseaseDTO);
    }

}
