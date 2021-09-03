package com.hospital_management.hospital.Controller;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.AppointmentDTO;
import com.hospital_management.hospital.Entity.Appointment;
import com.hospital_management.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public BaseResponse addAppointmentInfo(@RequestBody AppointmentDTO appointmentDTO) {
        return userService.addAppointmentInfo(appointmentDTO);
    }

    @GetMapping("/getAll")
    public List<Appointment> list(){
        return userService.listAllAppointment();
    }

    @DeleteMapping("/deleteId/{id}")
    public BaseResponse  deleteInfo(@PathVariable int id){
        return userService.deleteAppointmentById(id);
    }

    @PutMapping("update")
    public BaseResponse updateInfo(@RequestBody AppointmentDTO appointmentDTO){
        return userService.updateAppointmentById(appointmentDTO);
    }

}