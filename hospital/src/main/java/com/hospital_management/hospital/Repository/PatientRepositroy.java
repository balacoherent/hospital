package com.hospital_management.hospital.Repository;

import com.hospital_management.hospital.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositroy extends JpaRepository<Patient, Integer> {
}