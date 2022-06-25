package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;
import com.perscholas.poonamkajal.physicianadvisor.models.Address;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;
import com.perscholas.poonamkajal.physicianadvisor.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	@Autowired
	private PatientRepository patientRepository;

	public List<PatientDto> getAllPatient() {

		List<PatientDto> patientDtos = new ArrayList<PatientDto>();
		patientRepository.findAll().forEach(p -> {
			PatientDto pdto = new PatientDto();
			BeanUtils.copyProperties(p, pdto);
			patientDtos.add(pdto);
		});

		return patientDtos;
	}

	public PatientDto getPatientById(Long id) {
		Optional<Patient> p = patientRepository.findById(id);
		PatientDto pdto = new PatientDto();
		if (p.isPresent()) {
			BeanUtils.copyProperties(p.get(), pdto);
		}
		return pdto;
	}

	public void addPatient(PatientDto patient) {
		Patient p = new Patient();
		p.setAddress(new Address());
		BeanUtils.copyProperties(patient, p);
		BeanUtils.copyProperties(patient.getAddress(), p.getAddress());
		patientRepository.save(p);
	}

	public void updatePatient(long id, PatientDto patient) {
		Optional<Patient> patientData = patientRepository.findById(id);

		if (patientData.isPresent()) {
			Patient p = patientData.get();
			BeanUtils.copyProperties(patient, p);
			BeanUtils.copyProperties(patient.getAddress(), p.getAddress());
			System.out.println("Updating Case " + p.toString());
			patientRepository.saveAndFlush(p);
		}
	}

	public void deletePatient(long id) {
		patientRepository.deleteById(id);
	}

	public ResponseEntity<PatientDto> findById(Long id) {
		try {
			Optional<Patient> patient = patientRepository.findById(id);

			if (patient.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				PatientDto pdto = new PatientDto();
				BeanUtils.copyProperties(patient, pdto);
				return new ResponseEntity<>(pdto, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
