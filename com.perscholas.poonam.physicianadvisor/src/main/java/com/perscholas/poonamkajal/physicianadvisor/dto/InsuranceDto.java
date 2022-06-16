package com.perscholas.poonamkajal.physicianadvisor.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class InsuranceDto {
	@NotEmpty
	private Long id;

	@NotEmpty
	private String providerName;

	@NotEmpty
	private String insuranceId;

	@NotEmpty
	private String groupId;

	@NotEmpty
	private Date effectiveDate;

	@NotEmpty
	private Date expirationDate;

	@NotEmpty
	private String contactNo;

	@NotEmpty
	private String details;

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
		return "InsuranceDto [id=" + id + ", providerName=" + providerName + ", insuranceId=" + insuranceId
				+ ", groupId=" + groupId + ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate
				+ ", contactNo=" + contactNo + ", details=" + details + "]";
	}

	

}
