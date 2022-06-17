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

import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.InsuranceDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.DoctorServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.implementation.InsuranceServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;

@RestController
@RequestMapping("/api")
public class DoctorController {
	@Autowired
	private DoctorServiceImpl doctorService;
	
	@GetMapping("/doctor")
	   public List<DoctorDto> getAllDoctor(@RequestParam(required = false) Long Id){
	       return doctorService.getAllDoctor();
	      
	   }

	@GetMapping("/doctor/{id}")
	public DoctorDto getDoctorById(@PathVariable("id") Long id) {

		return doctorService.getDoctorById(id);
	}

	@PostMapping("/doctor")
	public void createDoctor(@RequestBody DoctorDto doctor) {
		doctorService.addDoctor(doctor);
	}

	@PutMapping("/doctor/{id}")
	public void updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDto d) {
		System.out.println("Update Case " + d.toString());
		doctorService.updateDoctor(id, d);
	}
	
	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@PathVariable("id") Long id) {
		doctorService.deleteDoctor(id);
	}

	@GetMapping("/doctor/id")
	public ResponseEntity<DoctorDto> findById(@PathVariable("id") Long id) {
		return doctorService.findById(id);
	}

}
