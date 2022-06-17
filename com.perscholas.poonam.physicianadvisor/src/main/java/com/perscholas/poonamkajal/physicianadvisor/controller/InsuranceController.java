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
import com.perscholas.poonamkajal.physicianadvisor.dto.InsuranceDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.InsuranceServiceImpl;

@RestController
@RequestMapping("/api")
public class InsuranceController {
	@Autowired
	private InsuranceServiceImpl insuranceService;
	
	@GetMapping("/insurance")
	   public List<InsuranceDto> getAllInsurance(@RequestParam(required = false) Long Id){
	       return insuranceService.getAllInsurance();
	      
	   }

	@GetMapping("/insurance/{id}")
	public InsuranceDto getInsuranceById(@PathVariable("id") Long id) {

		return insuranceService.getInsuranceById(id);
	}

	@PostMapping("/insurance")
	public void createInsurance(@RequestBody InsuranceDto insurance) {
		insuranceService.addInsurance(insurance);
	}

	@PutMapping("/insurance/{id}")
	public void updateInsurance(@PathVariable("id") Long id, @RequestBody InsuranceDto i) {
		System.out.println("Update Case " + i.toString());
		insuranceService.updateInsurance(id, i);
	}
	
	@DeleteMapping("/insurance/{id}")
	public void deleteInsurance(@PathVariable("id") Long id) {
		insuranceService.deleteInsurance(id);
	}

	@GetMapping("/insurance/id")
	public ResponseEntity<InsuranceDto> findById(@PathVariable("id") Long id) {
		return insuranceService.findById(id);
	}

}
