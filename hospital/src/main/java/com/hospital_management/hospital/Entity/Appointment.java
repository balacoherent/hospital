package com.hospital_management.hospital.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Integer appointmentId;

    @NotEmpty
    @Size(min = 3, message = "user name at least 3 characters")
    @Column(name = "appointment_name")
    private String appointmentName;


    @Column(name = "appointment_time")
    private Timestamp appointmentTime;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime updateDateTime;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_doctor_id")
    private Doctor doctor;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_disease_id")
    private Disease disease;

}
