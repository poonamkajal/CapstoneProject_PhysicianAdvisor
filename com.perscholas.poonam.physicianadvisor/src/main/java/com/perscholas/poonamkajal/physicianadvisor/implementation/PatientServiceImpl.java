package com.perscholas.poonamkajal.physicianadvisor.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.perscholas.poonamkajal.physicianadvisor.models.Patient;
import com.perscholas.poonamkajal.physicianadvisor.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatient() {

	       List<Patient> patient = new ArrayList<Patient>();
	       patientRepository.findAll().forEach(patient::add);
	       return patient;
	   }

	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}

	public void updatePatient(long id, Patient patient) {
		Optional<Patient> patientData = patientRepository.findById(id);

		if (patientData.isPresent()) {
			Patient _patient = patientData.get();
			_patient.setFirstName(patient.getFirstName());
			_patient.setLastName(patient.getLastName());
			_patient.setDob(patient.getDob());
			_patient.setEmail(patient.getEmail());
			_patient.setAddress(patient.getAddress());
			_patient.setContactNo(patient.getContactNo());
			_patient.setCreateDate(patient.getCreateDate());
			_patient.setCreatedBy(patient.getCreatedBy());
			_patient.setUpdatedBy(patient.getUpdatedBy());
			_patient.setUpdateDate(patient.getUpdateDate());
			patientRepository.save(_patient);
		}
	}
	public void deletePatient(long id) {
	       patientRepository.deleteById(id);
	   }
	public void deleteAllPatient() {
	       patientRepository.deleteAll();
	   }
	 public ResponseEntity<Optional<Patient>> findById() {
	       try {
	           Optional<Patient> patient = patientRepository.findById(null);

	           if (patient.isEmpty()) {
	               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	           }
	           return new ResponseEntity<>(patient, HttpStatus.OK);
	       } catch (Exception e) {
	           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       }
	   }
	}




