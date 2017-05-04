package com.gsp.mastek.registration.vo;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsp.mastek.common.vo.BaseVO;
import com.gsp.mastek.registration.enums.Gender;
import com.gsp.mastek.registration.enums.PartyType;

/**
 * Party generated by hbm2java
 */

public class PartyVO extends BaseVO {

	private Long partyId;
	private PartyType partyType;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherFirstName;
	private String fatherMiddleName;
	private String fatherLastName;
	private String husbandFirstName;
	private String husbandMiddleName;
	private String husbandLastName;
	private String designation;
	private Gender gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "IST")
	private Date dateOfBirth;
	private String isIndianCitizen;
	private String panNumber;
	private String passportNumber;
	private String aadharNumber;
	private String dinNumber;
	private String partyStatus;		
	private Set<PartyAddressVO> partyAddresses = new HashSet<PartyAddressVO>(0);

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}	

	public PartyType getPartyType() {
		return partyType;
	}

	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherMiddleName() {
		return fatherMiddleName;
	}

	public void setFatherMiddleName(String fatherMiddleName) {
		this.fatherMiddleName = fatherMiddleName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getHusbandFirstName() {
		return husbandFirstName;
	}

	public void setHusbandFirstName(String husbandFirstName) {
		this.husbandFirstName = husbandFirstName;
	}

	public String getHusbandMiddleName() {
		return husbandMiddleName;
	}

	public void setHusbandMiddleName(String husbandMiddleName) {
		this.husbandMiddleName = husbandMiddleName;
	}

	public String getHusbandLastName() {
		return husbandLastName;
	}

	public void setHusbandLastName(String husbandLastName) {
		this.husbandLastName = husbandLastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIsIndianCitizen() {
		return isIndianCitizen;
	}

	public void setIsIndianCitizen(String isIndianCitizen) {
		this.isIndianCitizen = isIndianCitizen;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getDinNumber() {
		return dinNumber;
	}

	public void setDinNumber(String dinNumber) {
		this.dinNumber = dinNumber;
	}

	public String getPartyStatus() {
		return partyStatus;
	}

	public void setPartyStatus(String partyStatus) {
		this.partyStatus = partyStatus;
	}

	public Set<PartyAddressVO> getPartyAddresses() {
		return partyAddresses;
	}

	public void setPartyAddresses(Set<PartyAddressVO> partyAddresses) {
		this.partyAddresses = partyAddresses;
	}

	@Override
	public String toString() {
		return "PartyVO [partyId=" + partyId + ", partyType=" + partyType + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", fatherFirstName=" + fatherFirstName + ", fatherMiddleName="
				+ fatherMiddleName + ", fatherLastName=" + fatherLastName + ", husbandFirstName=" + husbandFirstName
				+ ", husbandMiddleName=" + husbandMiddleName + ", husbandLastName=" + husbandLastName + ", designation="
				+ designation + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", isIndianCitizen="
				+ isIndianCitizen + ", panNumber=" + panNumber + ", passportNumber=" + passportNumber
				+ ", aadharNumber=" + aadharNumber + ", dinNumber=" + dinNumber + ", partyStatus=" + partyStatus
				+ ", partyAddresses=" + partyAddresses + "]";
	}

}
