package com.perscholas.poonamkajal.physicianadvisor.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;

@Service
public class CopyUtilities {

	public void copyHospital(HospitalDto source, Hospital target) {
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(source.getAddress(), target.getAddress());
	}

	public void copyPatient(PatientDto source, Patient target) {
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(source.getAddress(), target.getAddress());
	}

	public void copyCase(CaseDto source, Case target) {
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(source.getDoctor(), target.getDoctor());
		BeanUtils.copyProperties(source.getPrimaryInsurance(), target.getPrimaryInsurance());
		copyPatient(source.getPatient(), target.getPatient());
		copyHospital(source.getHospital(), target.getHospital());
	}

	public void copyHospitalDto(Hospital source, HospitalDto target) {
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(source.getAddress(), target.getAddress());
	}

	public void copyPatientDto(Patient source, PatientDto target) {
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(source.getAddress(), target.getAddress());
	}

	public void copyCaseDto(Case source, CaseDto target) {
		BeanUtils.copyProperties(source, target);
		BeanUtils.copyProperties(source.getDoctor(), target.getDoctor());
		BeanUtils.copyProperties(source.getPrimaryInsurance(), target.getPrimaryInsurance());
		copyPatientDto(source.getPatient(), target.getPatient());
		copyHospitalDto(source.getHospital(), target.getHospital());
	}
}
