package org.octank.claims.model;
// Generated Nov 28, 2018 2:11:05 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Patient generated by hbm2java
 */
@Entity
@Table(name = "PATIENT", catalog = "CLAIMS")
public class Patient implements java.io.Serializable {

	private String patientId;
	private String gender;
	private Date dateOfBirth;
	private String patientName;
	private String patientAddress;
	private String patientCity;
	private String patientState;
	private String patientZip;
	private String patientCountry;

	public Patient() {
	}

	public Patient(String patientId) {
		this.patientId = patientId;
	}

	public Patient(String patientId, String gender, Date dateOfBirth, String patientName, String patientAddress,
			String patientCity, String patientState, String patientZip, String patientCountry) {
		this.patientId = patientId;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientCity = patientCity;
		this.patientState = patientState;
		this.patientZip = patientZip;
		this.patientCountry = patientCountry;
	}

	@Id

	@Column(name = "PATIENT_ID", unique = true, nullable = false, length = 20)
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	@Column(name = "GENDER", length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OF_BIRTH", length = 26)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "PATIENT_NAME", length = 30)
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "PATIENT_ADDRESS", length = 50)
	public String getPatientAddress() {
		return this.patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	@Column(name = "PATIENT_CITY", length = 20)
	public String getPatientCity() {
		return this.patientCity;
	}

	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}

	@Column(name = "PATIENT_STATE", length = 20)
	public String getPatientState() {
		return this.patientState;
	}

	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}

	@Column(name = "PATIENT_ZIP", length = 20)
	public String getPatientZip() {
		return this.patientZip;
	}

	public void setPatientZip(String patientZip) {
		this.patientZip = patientZip;
	}

	@Column(name = "PATIENT_COUNTRY", length = 20)
	public String getPatientCountry() {
		return this.patientCountry;
	}

	public void setPatientCountry(String patientCountry) {
		this.patientCountry = patientCountry;
	}

}