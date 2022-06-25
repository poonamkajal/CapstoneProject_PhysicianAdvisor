package com.perscholas.poonamkajal.physicianadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
