package org.octank.claims.model;
// Generated Nov 26, 2018 8:17:52 PM by Hibernate Tools 5.2.11.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * InsurancePolicy generated by hbm2java
 */
@Entity
@Table(name = "INSURANCE_POLICY", catalog = "CLAIMS")
public class InsurancePolicy implements java.io.Serializable {

	private String insurancePolicyNbr;
	private String insuranceCompanyId;
	private String insuredGender;
	private String insuredMedicalCodes;
	private BigDecimal insuredAmount;

	public InsurancePolicy() {
	}

	public InsurancePolicy(String insurancePolicyNbr) {
		this.insurancePolicyNbr = insurancePolicyNbr;
	}

	public InsurancePolicy(String insurancePolicyNbr, String insuranceCompanyId, String insuredGender,
			String insuredMedicalCodes, BigDecimal insuredAmount) {
		this.insurancePolicyNbr = insurancePolicyNbr;
		this.insuranceCompanyId = insuranceCompanyId;
		this.insuredGender = insuredGender;
		this.insuredMedicalCodes = insuredMedicalCodes;
		this.insuredAmount = insuredAmount;
	}

	@Id

	@Column(name = "INSURANCE_POLICY_NBR", unique = true, nullable = false, length = 20)
	public String getInsurancePolicyNbr() {
		return this.insurancePolicyNbr;
	}

	public void setInsurancePolicyNbr(String insurancePolicyNbr) {
		this.insurancePolicyNbr = insurancePolicyNbr;
	}

	@Column(name = "INSURANCE_COMPANY_ID", length = 30)
	public String getInsuranceCompanyId() {
		return this.insuranceCompanyId;
	}

	public void setInsuranceCompanyId(String insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}

	@Column(name = "INSURED_GENDER", length = 20)
	public String getInsuredGender() {
		return this.insuredGender;
	}

	public void setInsuredGender(String insuredGender) {
		this.insuredGender = insuredGender;
	}

	@Column(name = "INSURED_MEDICAL_CODES", length = 200)
	public String getInsuredMedicalCodes() {
		return this.insuredMedicalCodes;
	}

	public void setInsuredMedicalCodes(String insuredMedicalCodes) {
		this.insuredMedicalCodes = insuredMedicalCodes;
	}

	@Column(name = "INSURED_AMOUNT", precision = 10)
	public BigDecimal getInsuredAmount() {
		return this.insuredAmount;
	}

	public void setInsuredAmount(BigDecimal insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

}
