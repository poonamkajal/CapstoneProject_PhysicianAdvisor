package com.perscholas.poonamkajal.physicianadvisor.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.perscholas.poonamkajal.physicianadvisor.dto.UserRegistrationDto;
import com.perscholas.poonamkajal.physicianadvisor.models.User;

public interface UserService extends UserDetailsService {
	User findByEmail(String email);

	User save(UserRegistrationDto registration);
}
