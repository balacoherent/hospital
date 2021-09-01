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
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotEmpty
    @Size(min = 3, message = "user name at least 3 characters")
    @Column(name = "user_name")
    private String userName;

    @NotEmpty
    @Size(min = 6, message = "password at least 6 characters")
    @Column(name = "password")
    private String password;

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

    @ManyToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "fk_user_id")
    private Appointment appointment;
}



