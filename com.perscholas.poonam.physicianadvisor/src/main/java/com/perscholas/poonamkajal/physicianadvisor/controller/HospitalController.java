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
import com.perscholas.poonamkajal.physicianadvisor.implementation.HospitalServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Hospital;

@RestController
@RequestMapping("/api")
public class HospitalController {
	
	@Autowired
	private HospitalServiceImpl hospitalService;
	
	@GetMapping("/hospital")
	   public List<Hospital> getAllHospital(@RequestParam(required = false) Long Id)         {
	       return hospitalService.getAllHospital();
	      
	   }

	@GetMapping("/hospital/{id}")
	public Optional<Hospital> getDoctorById(@PathVariable("id") Long id) {

		return hospitalService.getHospitalById(id);
	}

	@PostMapping("/hospital")
	public void createHospital(@RequestBody Hospital hospital) {
		hospitalService.addHospital(hospital);
	}

	@PutMapping("/hospital/{id}")
	public void updateHospital(@PathVariable("id") Long id, @RequestBody Hospital hospital) {
		Optional<Hospital> hospitalData = hospitalService.getHospitalById(id);

		if (hospitalData.isPresent()) {
			Hospital _hospital = hospitalData.get();
			_hospital.setName(hospital.getName());
			_hospital.setFacilityName(hospital.getFacilityName());
			_hospital.setAddress(hospital.getAddress());
			hospitalService.addHospital(_hospital);
		}
	}

	@DeleteMapping("/hospital/{id}")
	public void deleteHospital(@PathVariable("id") Long id) {
		hospitalService.deleteHospital(id);
	}

	@DeleteMapping("/hospital")
	public void deleteAllHospital() {

		hospitalService.deleteAllHospital();
	}

	@GetMapping("/hospital/id")
	public ResponseEntity<Optional<Hospital>> findById() {
		return hospitalService.findById();
	}


}
