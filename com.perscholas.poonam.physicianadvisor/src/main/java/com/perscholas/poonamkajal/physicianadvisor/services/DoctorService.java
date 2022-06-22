package com.perscholas.poonamkajal.physicianadvisor.services;

import java.util.Optional;

import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;

public interface DoctorService {
	Doctor findById(Long Id);
	   Doctor save(DoctorDto doctor);
}
