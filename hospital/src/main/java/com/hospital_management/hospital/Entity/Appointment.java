package com.hospital_management.hospital.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

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

    @CreationTimestamp
    @Column(name = "appointment_time")
    private Integer appointmentTime;

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

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_doctor_id")
    private List<Doctor> doctor;

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_patient_id")
    private List<Patient> patient;

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name = "fk_disease_id")
    private List<Disease> disease;

}
