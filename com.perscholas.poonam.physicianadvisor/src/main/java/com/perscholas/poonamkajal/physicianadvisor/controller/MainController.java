package com.perscholas.poonamkajal.physicianadvisor.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perscholas.poonamkajal.physicianadvisor.dto.CaseDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.CaseServiceImpl;

@Controller
public class MainController {

	@Autowired
	private CaseServiceImpl caseService;

	@GetMapping("/index")
	public String index(Model model) {

		Collection<? extends GrantedAuthority> userRoles;

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userRoles = ((UserDetails) principal).getAuthorities();

			for (GrantedAuthority userRole : userRoles) {
				if (userRole.getAuthority().equals("ROLE_ADMIN")) {
					List<CaseDto> cdtol = caseService.getAllCases();
					model.addAttribute("caselist", cdtol);
					return "cases/allcases";
				}
				if (userRole.getAuthority().equals("ROLE_DOCTOR")) {
					List<CaseDto> cdtol = caseService.getDocCases();
					model.addAttribute("doccaselist", cdtol);
					return "cases/doctorcases";
				}
				if (userRole.getAuthority().equals("ROLE_USER")) {
					List<CaseDto> cdtol = caseService.getUserCases();
					model.addAttribute("usercaselist", cdtol);
					return "cases/usercases";
				}
			}
		}

		return "index";
	}

	@GetMapping("/about")
	public String about(Model model) {
		return "about";
	}

	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}

	@GetMapping("/doctors")
	public String doctor(Model model) {
		return "doctors";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
}