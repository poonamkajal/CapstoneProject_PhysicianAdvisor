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
import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.HospitalServiceImpl;

@RestController
@RequestMapping("/api")
public class HospitalController {

	@Autowired
	private HospitalServiceImpl hospitalService;

	@GetMapping("/hospital")
	public List<HospitalDto> getAllHospital(@RequestParam(required = false) Long Id) {
		return hospitalService.getAllHospital();

	}

	@GetMapping("/hospital/{id}")
	public HospitalDto getHospitalById(@PathVariable("id") Long id) {

		return hospitalService.getHospitalById(id);
	}

	@PostMapping("/hospital")
	public void createHospital(@RequestBody HospitalDto hospital) {
		hospitalService.addHospital(hospital);
	}

	@PutMapping("/hospital/{id}")
	public void updateHospital(@PathVariable("id") Long id, @RequestBody HospitalDto h) {
		System.out.println("Update Case " + h.toString());
		hospitalService.updateHospital(id, h);
	}

	@DeleteMapping("/hospital/{id}")
	public void deleteHospital(@PathVariable("id") Long id) {
		hospitalService.deleteHospital(id);
	}

	@GetMapping("/hospital/id")
	public ResponseEntity<HospitalDto> findById(@PathVariable("id") Long id) {
		return hospitalService.findById(id);
	}

}
