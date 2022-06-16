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
import com.perscholas.poonamkajal.physicianadvisor.implementation.CaseServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;

@RestController
@RequestMapping("/api")
public class CaseController {
	@Autowired
	private CaseServiceImpl caseService;
	
	@GetMapping("/case")
	   public List<CaseDto> getAllCase(@RequestParam(required = false) Long Id)         {
	       return caseService.getAllCase();
	      
	   }

	@GetMapping("/case/{id}")
	public CaseDto getCaseById(@PathVariable("id") Long id) {

		return caseService.getCaseById(id);
	}

	@PostMapping("/case")
	public void createCase(@RequestBody CaseDto cases) {
		caseService.addCase(cases);
	}

	@PutMapping("/case/{id}")
	public void updateCase(@PathVariable("id") Long id, @RequestBody CaseDto c) {
		System.out.println("Update Case " + c.toString());
		caseService.updateCase(id, c);
	}
	
	@DeleteMapping("/case/{id}")
	public void deleteCase(@PathVariable("id") Long id) {
		caseService.deleteCase(id);
	}

	@GetMapping("/case/id")
	public ResponseEntity<CaseDto> findById(@PathVariable("id") Long id) {
		return caseService.findById(id);
	}

}
