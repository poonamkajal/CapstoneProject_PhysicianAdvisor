package com.perscholas.poonamkajal.physicianadvisor.services;



import java.util.Optional;
import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;

public interface PatientService {
	Patient findById(Long Id);
	   Patient save(PatientDto patient);
}

