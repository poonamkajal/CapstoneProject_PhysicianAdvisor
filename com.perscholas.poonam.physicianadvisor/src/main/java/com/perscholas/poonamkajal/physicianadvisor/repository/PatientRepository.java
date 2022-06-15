package com.perscholas.poonamkajal.physicianadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
