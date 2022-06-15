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
import com.perscholas.poonamkajal.physicianadvisor.implementation.DoctorServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
@RestController
@RequestMapping("/api")
public class DoctorController {
	@Autowired
	private DoctorServiceImpl doctorService;
	
	@GetMapping("/doctor")
	   public List<Doctor> getAllDoctor(@RequestParam(required = false) Long Id)         {
	       return doctorService.getAllDoctor();
	      
	   }

	@GetMapping("/doctor/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable("id") Long id) {

		return doctorService.getDoctorById(id);
	}

	@PostMapping("/doctor")
	public void createDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
	}

	@PutMapping("/doctor/{id}")
	public void updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) {
		Optional<Doctor> doctorData = doctorService.getDoctorById(id);

		if (doctorData.isPresent()) {
			Doctor _doctor = doctorData.get();
			_doctor.setFirstName(doctor.getFirstName());
			_doctor.setLastName(doctor.getLastName());
			_doctor.setSpeciality(doctor.getSpeciality());
			doctorService.addDoctor(_doctor);
		}
	}

	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@PathVariable("id") Long id) {
		doctorService.deleteDoctor(id);
	}

	@DeleteMapping("/doctor")
	public void deleteAllDoctors() {

		doctorService.deleteAllDoctor();
	}

	@GetMapping("/doctor/id")
	public ResponseEntity<Optional<Doctor>> findById() {
		return doctorService.findById();
	}


}