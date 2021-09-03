package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.DoctorDTO;
import com.hospital_management.hospital.Entity.Doctor;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public BaseResponse addDoctorInfo(@RequestBody DoctorDTO doctorDTO) {
        return userService.addDoctorInfo(doctorDTO);
    }
    @GetMapping("/doctorId/{id}")
    public Doctor getDoctorInfo(@PathVariable int id){
        return userService.getDoctorById(id);
    }

    @DeleteMapping("/deleteId/{id}")
    public BaseResponse  deleteInfo(@PathVariable int id){
        return userService.deleteDoctorById(id);
    }

    @PutMapping("update")
    public BaseResponse updateInfo(@RequestBody DoctorDTO doctorDTO){
        return userService.updateDoctorById(doctorDTO);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ApiResponse<Page<Doctor>> doctorWithPaginationInfo(@PathVariable int offset, @PathVariable int pageSize){
        Page<Doctor> Pagination = userService.findDoctorWithPagination(offset, pageSize);
        return new ApiResponse<>(Pagination.getSize(),Pagination);
    }
}

