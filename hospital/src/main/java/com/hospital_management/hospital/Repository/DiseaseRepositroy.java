package com.hospital_management.hospital.Repository;

import com.hospital_management.hospital.Entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepositroy extends JpaRepository<Disease, Integer> {
}
