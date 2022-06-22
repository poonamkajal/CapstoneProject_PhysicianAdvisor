package com.perscholas.poonamkajal.physicianadvisor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.perscholas.poonamkajal.physicianadvisor.implementation.CaseServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.implementation.DoctorServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.implementation.HospitalServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;

@Controller
@RequestMapping("cases")
public class CaseController {
	@Autowired
	private CaseServiceImpl caseService;
	
	@Autowired
	private DoctorServiceImpl doctorService;
	
	@Autowired
	private HospitalServiceImpl hospitalService;

	@GetMapping("/addcase")
	public String addCase(Model model){
		CaseDto cdto = new CaseDto();
		model.addAttribute("cases", cdto);
		
		List<DoctorDto> alldoctors = doctorService.getAllDoctor();
		model.addAttribute("doctors",alldoctors);

		List<HospitalDto> allhospitals = hospitalService.getAllHospital();
		model.addAttribute("hospitals",allhospitals);

		return "cases/addcase";	      
	}

	@GetMapping("/update/{id}")
	public String updateCase(@PathVariable("id") Long id, Model model) {		
	      CaseDto cdto = caseService.getCaseById(id);
		model.addAttribute("cases", cdto);
	    return "cases/updatecase";
	}
	
	@GetMapping("/allcases")
	public String getAllCases(Model model){
		List<CaseDto> cdtol = caseService.getAllCase();
		model.addAttribute("caselist", cdtol);
	    return "cases/allcases";
	}

	@GetMapping("/id/{id}")
	public CaseDto getCaseById(@PathVariable("id") Long id) {

		return caseService.getCaseById(id);
	}

	@PostMapping("/save")
	public String saveCase(@ModelAttribute("cases") @Valid CaseDto cases, BindingResult errors, Model model) {
		System.out.println("Saving case " + cases.toString());
		
		if (cases.getDoctor().getId() != null) {
			cases.setDoctor(doctorService.getDoctorById(cases.getDoctor().getId()));
		}
		
		if (cases.getHospital().getId() != null) {
			cases.setHospital(hospitalService.getHospitalById(cases.getHospital().getId()));
		}

		if (cases.getId() == null) {
			caseService.addCase(cases);
		}
		else {
			caseService.updateCase(cases.getId(), cases);
		}
				
		return "redirect:/cases/allcases";
	}

	@GetMapping("/delete/{id}")
	public String deleteCase(@PathVariable("id") Long id, Model model) {
		caseService.deleteCase(id);
		return "redirect:/cases/allcases";
	}
}
