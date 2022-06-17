package com.perscholas.poonamkajal.physicianadvisor.models;

import java.util.Date;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cases")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Case {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Patient patient = new Patient();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Doctor doctor = new Doctor();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Hospital hospital = new Hospital();
	
	private Date dateOfAdmission;
	private Date dateOfDischarge;
	private String medicalRecordId;
	private String diagnosis; // comma separated diagnosis

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Insurance primaryInsurance = new Insurance();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Insurance secondaryInsurance;
	
	private String attendingDoctorName;
	private String attendingDoctorContactNo;
	private String paReco; // Physician Advisor Doctor's recommendations for the case
	private String caseStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
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
	public Insurance getPrimaryInsurance() {
		return primaryInsurance;
	}
	public void setPrimaryInsurance(Insurance primaryInsurance) {
		this.primaryInsurance = primaryInsurance;
	}
	public Insurance getSecondaryInsurance() {
		return secondaryInsurance;
	}
	public void setSecondaryInsurance(Insurance secondaryInsurance) {
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
		return "Case [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", hospital=" + hospital
				+ ", dateOfAdmission=" + dateOfAdmission + ", dateOfDischarge=" + dateOfDischarge + ", medicalRecordId="
				+ medicalRecordId + ", diagnosis=" + diagnosis + ", primaryInsurance=" + primaryInsurance
				+ ", secondaryInsurance=" + secondaryInsurance + ", attendingDoctorName=" + attendingDoctorName
				+ ", attendingDoctorContactNo=" + attendingDoctorContactNo + ", paReco=" + paReco + ", caseStatus="
				+ caseStatus + "]";
	}
	
	
}
