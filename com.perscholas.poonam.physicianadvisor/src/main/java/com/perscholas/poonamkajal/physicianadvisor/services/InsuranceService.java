package com.perscholas.poonamkajal.physicianadvisor.services;

import com.perscholas.poonamkajal.physicianadvisor.dto.InsuranceDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Insurance;

public interface InsuranceService {
	Insurance findById(Long Id);

	Insurance save(InsuranceDto insurance);
}
