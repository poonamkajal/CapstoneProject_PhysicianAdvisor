package com.perscholas.poonamkajal.physicianadvisor.services;

import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;

public interface HospitalService {
	Hospital findById(Long Id);
	   Hospital save(HospitalDto hospital);
}
