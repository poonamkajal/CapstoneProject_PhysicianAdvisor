package com.perscholas.poonamkajal.physicianadvisor.controller;

import java.util.List;
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
import com.perscholas.poonamkajal.physicianadvisor.dto.PatientDto;

@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	private PatientServiceImpl patientService;
	
	@GetMapping("/patient")
	   public List<PatientDto> getAllPatient(@RequestParam(required = false) Long Id){
	       return patientService.getAllPatient();
	      
	   }

	@GetMapping("/patient/{id}")
	public PatientDto getPatientById(@PathVariable("id") Long id) {

		return patientService.getPatientById(id);
	}

	@PostMapping("/patient")
	public void createPatient(@RequestBody PatientDto patient) {
		patientService.addPatient(patient);
	}

	@PutMapping("/patient/{id}")
	public void updatePatient(@PathVariable("id") Long id, @RequestBody PatientDto p) {
		System.out.println("Update Case " + p.toString());
		patientService.updatePatient(id, p);
	}
	
	@DeleteMapping("/patient/{id}")
	public void deletePatient(@PathVariable("id") Long id) {
		patientService.deletePatient(id);
	}

	@GetMapping("/patient/id")
	public ResponseEntity<PatientDto> findById(@PathVariable("id") Long id) {
		return patientService.findById(id);
	}

}
