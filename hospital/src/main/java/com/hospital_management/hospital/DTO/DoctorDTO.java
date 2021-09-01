package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Data
@Getter
@Setter

public class DoctorDTO {

    private Integer doctorId;

    private String doctorName;

    private Boolean isActive;

    private Boolean isDelete;

    private List<PatientDTO> patientDTO;
}
