package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TokenDTO {
    private String token;
    private String name;
    private String password;
}