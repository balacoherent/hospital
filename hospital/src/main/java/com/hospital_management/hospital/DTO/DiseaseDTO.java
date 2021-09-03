package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

public class DiseaseDTO {

    private Integer diseaseId;

    private String diseaseName;

    private int isActive;

    private int isDelete;
}
