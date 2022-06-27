package com.perscholas.poonamkajal.physicianadvisor;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.perscholas.poonamkajal.physicianadvisor.controller.DoctorController;
import com.perscholas.poonamkajal.physicianadvisor.dto.DoctorDto;
import com.perscholas.poonamkajal.physicianadvisor.implementation.DoctorServiceImpl;
import com.perscholas.poonamkajal.physicianadvisor.models.Doctor;
import com.perscholas.poonamkajal.physicianadvisor.repository.DoctorRepository;

@SpringBootTest
class ApplicationTests {

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
	    DoctorDto doctor = new DoctorDto((long) 0,"Kamal", "Kajal", "kamal@doctor.com");
	    	 
	    Doctor retd = service.addDoctor(doctor);
	 
	    DoctorDto doctordata = service.getDoctorById(retd.getId());
	    Assertions.assertThat(doctordata).hasFieldOrPropertyWithValue("firstName", "Kamal");
	 
	    System.out.println("Doctor is " + retd);
	    
	    service.deleteDoctor(retd.getId());
	    Assertions.assertThat(service.getDoctorById(retd.getId()).getId()).isNull();
	  }
}