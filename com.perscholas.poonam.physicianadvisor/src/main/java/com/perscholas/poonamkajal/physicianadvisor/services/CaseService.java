package com.perscholas.poonamkajal.physicianadvisor.services;


import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;

public interface CaseService {
	Case findById(Long Id);
	   Case save(CaseDto cases);
}
