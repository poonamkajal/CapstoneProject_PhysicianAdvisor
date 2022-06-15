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
import com.perscholas.poonamkajal.physicianadvisor.implementation.InsuranceServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.models.Insurance;

@RestController
@RequestMapping("/api")
public class InsuranceController {
	@Autowired
	private InsuranceServiceImpl insuranceService;
	
	@GetMapping("/insurance")
	   public List<Insurance> getAllInsurance(@RequestParam(required = false) Long Id)         {
	       return insuranceService.getAllInsurance();
	      
	   }

	@GetMapping("/insurance/{id}")
	public Optional<Insurance> getInsuranceById(@PathVariable("id") Long id) {

		return insuranceService.getInsuranceById(id);
	}

	@PostMapping("/insurance")
	public void createInsurance(@RequestBody Insurance insurance) {
		insuranceService.addInsurance(insurance);
	}

	@PutMapping("/insurance/{id}")
	public void updateInsurance(@PathVariable("id") Long id, @RequestBody Insurance insurance) {
		Optional<Insurance> insuranceData = insuranceService.getInsuranceById(id);

		if (insuranceData.isPresent()) {
			Insurance _insurance = insuranceData.get();
			_insurance.setProviderName(insurance.getProviderName());
			_insurance.setInsuranceId(insurance.getInsuranceId());
			_insurance.setGroupId(insurance.getGroupId());
			_insurance.setContactNo(insurance.getContactNo());
			_insurance.setEffectiveDate(insurance.getEffectiveDate());
			_insurance.setExpirationDate(insurance.getEffectiveDate());
			_insurance.setDetails(insurance.getDetails());
			
			insuranceService.addInsurance(_insurance);
		}
	}

	@DeleteMapping("/insurance/{id}")
	public void deleteInsurance(@PathVariable("id") Long id) {
		insuranceService.deleteInsurance(id);
	}

	@DeleteMapping("/insurance")
	public void deleteAllInsurance() {

		insuranceService.deleteAllInsurance();
	}

	@GetMapping("/insurance/id")
	public ResponseEntity<Optional<Insurance>> findById() {
		return insuranceService.findById();
	}


}