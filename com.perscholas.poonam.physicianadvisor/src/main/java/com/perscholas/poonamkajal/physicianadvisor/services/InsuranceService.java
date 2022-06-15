package com.perscholas.poonamkajal.physicianadvisor.services;

import java.util.Optional;

import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.InsuranceDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.models.Insurance;

public interface InsuranceService {
	Optional<Insurance> findByInsuranceId(Long insuranceId);
	   Doctor save(InsuranceDto doctorinfo);
}