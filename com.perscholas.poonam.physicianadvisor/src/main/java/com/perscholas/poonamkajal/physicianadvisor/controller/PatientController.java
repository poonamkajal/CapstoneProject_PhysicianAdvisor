package com.perscholas.poonamkajal.physicianadvisor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perscholas.poonamkajal.physicianadvisor.implementation.PatientServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Patient;

@RestController
@RequestMapping("/api")

public class PatientController {
	@Autowired
	private PatientServiceImpl patientService;
	
	@GetMapping("/patient")
	   public List<Patient> getAllPatient(@RequestParam(required = false) String title)         {
	       return patientService.getAllPatient();
	      
	   }

	@GetMapping("/patient/{id}")
	public Optional<Patient> getPatientById(@PathVariable("id") long id) {

		return patientService.getPatientById(id);
	}

	@PostMapping("/patient")
	public void createPatient(@RequestBody Patient patient) {
		patientService.addPatient(patient);
	}

	@PutMapping("/patient/{id}")
	public void updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
		Optional<Patient> patientData = patientService.getPatientById(id);

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
			patientService.addPatient(_patient);
		}
	}

	@DeleteMapping("/patient/{id}")
	public void deletePatient(@PathVariable("id") long id) {
		patientService.deletePatient(id);
	}

	@DeleteMapping("/patient")
	public void deleteAllTutorials() {

		patientService.deleteAllPatient();
	}

	@GetMapping("/patient/id")
	public ResponseEntity<Optional<Patient>> findById() {
		return patientService.findById();
	}

}