package com.hospital_management.hospital.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Data
@Getter
@Setter

public class PatientDTO {

    private Integer patientId;

    private String patientName;

    private Boolean isActive;

    private Boolean isDelete;

    private List<DiseaseDTO> diseaseDTO;

}
