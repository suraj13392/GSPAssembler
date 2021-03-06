package com.gsp.mastek.registration.model;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.gsp.mastek.common.entity.BaseEntity;

/**
 * PartyAddress generated by hbm2java
 */
@Entity
@Audited
public class PartyAddress extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long partyaddressId;
	
	private String buildingNumber;
	
	private String floorNumber;
	
	private String buildingName;
	
	private String street;
	
	private String locality;
	
	private String district;
	
	private String stateCd;
	
	private String pinCode;
	
	@NotAudited
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "partyaddressId", referencedColumnName = "partyaddressId")
	private Set<PartyContact> partyContacts;

	public Long getPartyaddressId() {
		return partyaddressId;
	}

	public void setPartyaddressId(Long partyaddressId) {
		this.partyaddressId = partyaddressId;
	}
	
	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Set<PartyContact> getPartyContacts() {
		return partyContacts;
	}

	public void setPartyContacts(Set<PartyContact> partyContacts) {
		this.partyContacts = partyContacts;
	}
	
	public void addPartyContact(PartyContact partyContact) {
		if (this.partyContacts == null) {
			this.partyContacts = new HashSet<PartyContact>();
			this.partyContacts.add(partyContact);
		} else {
			this.partyContacts.add(partyContact);
		}
	}

	@Override
	public String toString() {
		return "PartyAddress [partyaddressId=" + partyaddressId  + ", buildingNumber="
				+ buildingNumber + ", floorNumber=" + floorNumber + ", buildingName=" + buildingName + ", street="
				+ street + ", locality=" + locality + ", district=" + district + ", stateCd=" + stateCd + ", pinCode="
				+ pinCode + ", partyContacts=" + partyContacts + "]";
	}

}
