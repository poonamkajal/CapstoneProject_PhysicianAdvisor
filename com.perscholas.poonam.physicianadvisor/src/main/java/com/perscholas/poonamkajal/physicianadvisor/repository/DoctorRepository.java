package com.perscholas.poonamkajal.physicianadvisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	Doctor findByEmail(String email);

	void save(DoctorDto doctor);
}
