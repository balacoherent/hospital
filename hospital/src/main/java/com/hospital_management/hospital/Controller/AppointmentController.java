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

    @PostMapping("/addAppointment")
    public BaseResponse addAppointmentInfo(@RequestBody AppointmentDTO appointmentDTO) {
        return userService.addAppointmentInfo(appointmentDTO);
    }

    @GetMapping("/getAll")
    public List<Appointment> listAllAppointment(){
        return userService.listAllAppointment();
    }

    @GetMapping("/appointmentId/{id}")
    public BaseResponse<Appointment> getAppointmentById(@PathVariable Integer id){
        return userService.getAppointmentById(id);
    }

    @PutMapping("/deleteSoft")
    public BaseResponse  deleteSoftAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return userService.deleteSoftAppointment(appointmentDTO);
    }

    @PutMapping("/update")
    public BaseResponse updateInfo(@RequestBody AppointmentDTO appointmentDTO){
        return userService.updateAppointmentById(appointmentDTO);
    }

}