package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter
@Setter

public class DoctorDTO {

    private Integer doctorId;

    private String doctorName;

    private Integer userId;

    private int isActive;

    private int isDelete;

}
