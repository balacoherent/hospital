package com.hospital_management.hospital.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

public class UserDTO {

    private Integer userId;

    private String userName;

    private String password;

    private int isActive;

    private int isDelete;

}