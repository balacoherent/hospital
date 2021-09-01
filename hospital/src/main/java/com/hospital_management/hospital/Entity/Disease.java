package com.hospital_management.hospital.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name="Disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_id")
    private Integer diseaseId;


    @NotEmpty
    @Size(min = 3, message = "user name at least 3 characters")
    @Column(name = "patient_Name")
    private String diseaseName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDateTime;

    @CreationTimestamp
    @Column(name = "modified_at")
    private LocalDateTime updateDateTime;

}