package com.perscholas.poonamkajal.physicianadvisor.services;



import java.util.Optional;

import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;

public interface PatientService {
   Optional<Patient> findBypatientId(Long patientId);
   Patient save(PatientDto patientinfo);
}

