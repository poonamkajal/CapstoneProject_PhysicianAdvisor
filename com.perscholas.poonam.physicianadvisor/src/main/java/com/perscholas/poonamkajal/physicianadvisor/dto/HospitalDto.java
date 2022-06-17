package com.perscholas.poonamkajal.physicianadvisor.dto;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDto {
	
	private Long id;
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String facilityName;
	
	@NotEmpty
	private AddressDto address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "HospitalDto [id=" + id + ", name=" + name + ", facilityName=" + facilityName + ", address=" + address
				+ "]";
	}
	
}
