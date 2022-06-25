package com.perscholas.poonamkajal.physicianadvisor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.poonamkajal.physicianadvisor.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	// User findByConfirmationToken(String confirmationToken);

	List<User> findAll();
}
