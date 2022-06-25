package com.perscholas.poonamkajal.physicianadvisor.services;

import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;

public interface DoctorService {
	Doctor findById(Long Id);

	Doctor save(DoctorDto doctor);
}
