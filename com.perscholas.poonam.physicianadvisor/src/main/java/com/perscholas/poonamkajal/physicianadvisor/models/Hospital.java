package com.perscholas.poonamkajal.physicianadvisor.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Hospital")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long id;
	   private String name;
	   private String facilityName;
		
	   @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
       private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", facilityName=" + facilityName + ", address=" + address
				+ "]";
	}

}
