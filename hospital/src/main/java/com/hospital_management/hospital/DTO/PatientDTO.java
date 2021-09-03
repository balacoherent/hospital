package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

public class PatientDTO {

    private Integer patientId;

    private String patientName;

    private Integer userId;

    private int isActive;

    private int isDelete;

}
