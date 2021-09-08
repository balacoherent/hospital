package com.hospital_management.hospital.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {

    private Integer userId;

    private String userName;

    private String password;

    private int isActive;

    private int isDelete;

}