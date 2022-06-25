package com.perscholas.poonamkajal.physicianadvisor.services;

import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;

public interface PatientService {
	Patient findById(Long Id);

	Patient save(PatientDto patient);
}
