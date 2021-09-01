package com.hospital_management.hospital.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter

public class UserDTO {

    private Integer userId;

    private String userName;

    private String password;

    private Boolean isActive;

    private Boolean isDelete;

    private List<AppointmentDTO> appointmentDTO;

}