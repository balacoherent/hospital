package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.sql.Time;
import java.sql.Timestamp;


@Data
@Getter
@Setter

public class AppointmentDTO {

    private Integer appointmentId;

    private String appointmentName;

    private Timestamp appointmentTime;

    private Integer diseaseId;

    private Integer patientId;

    private Integer doctorId;

    private int isActive;

    private int isDelete;

}
