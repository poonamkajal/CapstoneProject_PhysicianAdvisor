package com.perscholas.poonamkajal.physicianadvisor.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;

public interface CaseService {
	Case findById(Long Id);

	Case save(CaseDto cases);

	List<PatientDto> findByPatientId(@Param("id") Long id);

}
