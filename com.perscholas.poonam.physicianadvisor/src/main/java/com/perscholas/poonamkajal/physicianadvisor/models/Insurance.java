package com.perscholas.poonamkajal.physicianadvisor.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Insurance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String providerName;
	private String insuranceId;
	private String groupId;
	private Date effectiveDate;
	private Date expirationDate;
	private String contactNo;
	private String details; // Copay, deductible etc. for physician advisor doctor's info

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", providerName=" + providerName + ", insuranceId=" + insuranceId + ", groupId="
				+ groupId + ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate + ", contactNo="
				+ contactNo + ", details=" + details + "]";
	}

}
