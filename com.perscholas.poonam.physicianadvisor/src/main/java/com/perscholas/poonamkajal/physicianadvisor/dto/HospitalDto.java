package com.perscholas.poonamkajal.physicianadvisor.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class HospitalDto {
	
	@NotEmpty
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String facilityName;
	
	@NotEmpty
	private String addressLine1;

	private String addressLine2;

	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state; //2-letter state code

	@NotEmpty
	private String zipcode; // 5-digit zip code

	@NotEmpty
	private String country; // Always USA
}
