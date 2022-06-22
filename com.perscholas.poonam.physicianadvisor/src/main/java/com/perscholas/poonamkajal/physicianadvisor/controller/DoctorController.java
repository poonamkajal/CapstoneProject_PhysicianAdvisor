package com.perscholas.poonamkajal.physicianadvisor.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.DoctorServiceImpl;

@Controller
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	private DoctorServiceImpl doctorService;
	
	@GetMapping("/add")
	public String addDoctor(Model model){
		DoctorDto ddto = new DoctorDto();
		model.addAttribute("doctor", ddto);
	    return "doctor/add";	      
	}

	@GetMapping("/update/{id}")
	public String updateDoctor(@PathVariable("id") Long id, Model model) {		
		DoctorDto ddto = doctorService.getDoctorById(id);
		model.addAttribute("doctor", ddto);
	    return "doctor/update";
	}
	
	@GetMapping("/alldoctors")
	public String getAllDoctors(Model model){
		List<DoctorDto> ddtol = doctorService.getAllDoctor();
		model.addAttribute("doctors", ddtol);
	    return "doctor/alldoctors";
	}

	@GetMapping("/id/{id}")
	public DoctorDto getDoctorById(@PathVariable("id") Long id) {

		return doctorService.getDoctorById(id);
	}

	@PostMapping("/save")
	public String saveDoctor(@ModelAttribute("doctor") DoctorDto doc, BindingResult errors, Model model) {
		System.out.println("Saving doctor " + doc.toString());
		
		if (doc.getId() == null) {
			doctorService.addDoctor(doc);
		}
		else {
			doctorService.updateDoctor(doc.getId(), doc);
		}
				
		return "redirect:/doctor/alldoctors";
	}

	@GetMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable("id") Long id, Model model) {
		doctorService.deleteDoctor(id);
		return "redirect:/doctor/alldoctors";
	}

}
