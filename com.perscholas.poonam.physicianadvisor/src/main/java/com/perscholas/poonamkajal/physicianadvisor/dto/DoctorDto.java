package com.perscholas.poonamkajal.physicianadvisor.dto;

import org.hibernate.validator.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
	@NotEmpty
	private Long id;
	
	@NotEmpty
    private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String speciality;
}
