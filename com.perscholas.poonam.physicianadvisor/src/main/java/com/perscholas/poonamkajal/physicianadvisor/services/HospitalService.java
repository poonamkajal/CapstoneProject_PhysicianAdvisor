package com.perscholas.poonamkajal.physicianadvisor.services;

import java.util.Optional;
import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;

public interface HospitalService {
	Optional<Hospital> findByHospitalId(Long hospitalId);
	   Doctor save(HospitalDto hospitalinfo);
}