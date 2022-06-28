package com.perscholas.poonamkajal.physicianadvisor.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDto {

	private Long id;

	private PatientDto patient = new PatientDto();

	private DoctorDto doctor = new DoctorDto();

	@NotNull
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { "M/d/yy", "MM.DD.yyyy" })
	private Date dateOfAdmission;
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { "M/d/yy", "MM.DD.yyyy" })

	private Date dateOfDischarge;

	@NotEmpty
	private String medicalRecordId;

	@NotEmpty
	private String diagnosis;

	private HospitalDto hospital = new HospitalDto();

	private InsuranceDto primaryInsurance = new InsuranceDto();

	private InsuranceDto secondaryInsurance = new InsuranceDto();

	@NotEmpty
	private String attendingDoctorName;

	@NotEmpty
	private String attendingDoctorContactNo;

	@NotEmpty
	private String paReco;

	@NotEmpty
	private String caseStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PatientDto getPatient() {
		return patient;
	}

	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Date getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public HospitalDto getHospital() {
		return hospital;
	}

	public void setHospital(HospitalDto hospital) {
		this.hospital = hospital;
	}

	public InsuranceDto getPrimaryInsurance() {
		return primaryInsurance;
	}

	public void setPrimaryInsurance(InsuranceDto primaryInsurance) {
		this.primaryInsurance = primaryInsurance;
	}

	public InsuranceDto getSecondaryInsurance() {
		return secondaryInsurance;
	}

	public void setSecondaryInsurance(InsuranceDto secondaryInsurance) {
		this.secondaryInsurance = secondaryInsurance;
	}

	public String getAttendingDoctorName() {
		return attendingDoctorName;
	}

	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}

	public String getAttendingDoctorContactNo() {
		return attendingDoctorContactNo;
	}

	public void setAttendingDoctorContactNo(String attendingDoctorContactNo) {
		this.attendingDoctorContactNo = attendingDoctorContactNo;
	}

	public String getPaReco() {
		return paReco;
	}

	public void setPaReco(String paReco) {
		this.paReco = paReco;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	@Override
	public String toString() {
		return "CaseDto [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", dateOfAdmission="
				+ dateOfAdmission + ", dateOfDischarge=" + dateOfDischarge + ", medicalRecordId=" + medicalRecordId
				+ ", diagnosis=" + diagnosis + ", hospital=" + hospital + ", primaryInsurance=" + primaryInsurance
				+ ", secondaryInsurance=" + secondaryInsurance + ", attendingDoctorName=" + attendingDoctorName
				+ ", attendingDoctorContactNo=" + attendingDoctorContactNo + ", paReco=" + paReco + ", caseStatus="
				+ caseStatus + "]";
	}

}
