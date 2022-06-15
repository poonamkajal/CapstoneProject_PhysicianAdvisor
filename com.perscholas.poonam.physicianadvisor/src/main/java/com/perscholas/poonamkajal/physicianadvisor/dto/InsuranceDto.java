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
}
