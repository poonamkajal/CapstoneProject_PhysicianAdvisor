package com.perscholas.poonamkajal.physicianadvisor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.perscholas.poonamkajal.physicianadvisor.controller.DoctorController;

@SpringBootTest
class ApplicationTests {

	  @Autowired
	  DoctorController doctorController;
	 
	  @Test
	  public void contextLoads() {
	    Assertions.assertThat(doctorController).isNotNull();
	  }
	  
	  
}
