package com.perscholas.poonamkajal.physicianadvisor.services;

import java.util.Optional;

import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;

public interface DoctorService {
	Optional<Doctor> findBydoctorId(Long doctorId);
	   Doctor save(DoctorDto doctorinfo);
}
