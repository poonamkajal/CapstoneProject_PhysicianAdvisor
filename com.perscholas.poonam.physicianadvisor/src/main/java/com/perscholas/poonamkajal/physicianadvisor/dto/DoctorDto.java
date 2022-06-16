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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "DoctorDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", speciality="
				+ speciality + "]";
	}

	
	
	
}
