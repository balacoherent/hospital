package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Data
@Getter
@Setter

public class AppointmentDTO {

    private Integer appointmentId;

    private String appointmentName;

    private Integer appointmentTime;

    private Boolean isActive;

    private Boolean isDelete;

    private List<DoctorDTO> doctorDTO;
}
