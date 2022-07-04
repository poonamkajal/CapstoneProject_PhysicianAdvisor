package com.perscholas.poonamkajal.physicianadvisor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import com.perscholas.poonamkajal.physicianadvisor.controller.DoctorController;
import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.DoctorServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.implementation.UserServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.repository.DoctorRepository;

@Suite
@SpringBootTest
class ApplicationTests {

	@Autowired
	UserServiceImpl userSvc;

	@Autowired
	DoctorController doctorController;

	@Autowired
	DoctorServiceImpl service;

	@InjectMocks
	DoctorServiceImpl servicemock;

	@Mock
	DoctorRepository dao;

	@Test
	public void contextLoads() {
		Assertions.assertThat(doctorController).isNotNull();
	}

	@Test
	public void testCreateOrSaveDoctor() {
		DoctorDto doctor = new DoctorDto((long) 0, "Kamal", "Kajal", "kamal@doctor.com");

		servicemock.addDoctor(doctor);

		verify(dao, times(1));
	}

	@Test
	public void testCreateReadDelete() {
		DoctorDto doctor = new DoctorDto((long) 0, "Kamal", "Kajal", "kamal@doctor.com");

		Doctor retd = service.addDoctor(doctor);

		DoctorDto doctordata = service.getDoctorById(retd.getId());
		Assertions.assertThat(doctordata).hasFieldOrPropertyWithValue("firstName", "Kamal");

		System.out.println("Doctor is " + retd);

		service.deleteDoctor(retd.getId());
		Assertions.assertThat(service.getDoctorById(retd.getId()).getId()).isNull();
	}

	@Test
	void testUserServiceCurrentUser() {
		UserDetails ud = userSvc.loadUserByUsername("poonam2004@gmail.com");
		assertNotNull(ud);
		assertEquals("poonam2004@gmail.com", ud.getUsername());
	}
}