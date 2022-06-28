package com.perscholas.poonamkajal.physicianadvisor.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.perscholas.poonamkajal.physicianadvisor.dto.HospitalDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.HospitalServiceImpl;

@Controller
@RequestMapping("hospital")
public class HospitalController {

	private static final Logger log = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	private HospitalServiceImpl hospitalService;

	@GetMapping("/addhospital")
	public String addHospital(Model model) {
		HospitalDto hdto = new HospitalDto();
		model.addAttribute("hospital", hdto);
		return "hospital/addhospital";
	}

	@GetMapping("/update/{id}")
	public String updateHospital(@PathVariable("id") Long id, Model model) {
		System.out.println("Update hospital " + id);
		HospitalDto hdto = hospitalService.getHospitalById(id);
		model.addAttribute("hospital", hdto);
		return "hospital/updatehospital";
	}

	@GetMapping("/allhospitals")
	public String getAllHospital(Model model) {
		List<HospitalDto> hdtol = hospitalService.getAllHospital();
		model.addAttribute("hospitals", hdtol);
		return "hospital/allhospitals";
	}

	@GetMapping("/id/{id}")
	public HospitalDto getHospitalById(@PathVariable("id") Long id) {

		return hospitalService.getHospitalById(id);
	}

	@PostMapping("/save")
	public String saveHospital(@ModelAttribute("hospital") @Valid HospitalDto hos, BindingResult errors, Model model) {
		System.out.println("Saving hospital " + hos.toString());

		if (hos.getId() == null) {
			hospitalService.addHospital(hos);

		} else {
			hospitalService.updateHospital(hos.getId(), hos);
		}

		return "redirect:/hospital/allhospitals";
	}

	@GetMapping("/delete/{id}")
	public String deleteHospital(@PathVariable("id") Long id, Model model) {
		hospitalService.deleteHospital(id);
		return "redirect:/hospital/allhospitals";
	}
}
