package com.gsp.mastek.registration.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrganizationDetailsResponseVO{
	
	private Long organizationId;
	private String legalName;
	private String tradeName;
	private String panNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "IST")
	private Date commencementDt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "IST")
	private Date gstnRegistrationDt;
	private String organizationStatus;
	private List<OrganizationAddressVO> addressDetails ;
	
	public List<OrganizationAddressVO> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(List<OrganizationAddressVO> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Date getCommencementDt() {
		return commencementDt;
	}

	public void setCommencementDt(Date commencementDt) {
		this.commencementDt = commencementDt;
	}

	public Date getGstnRegistrationDt() {
		return gstnRegistrationDt;
	}

	public void setGstnRegistrationDt(Date gstnRegistrationDt) {
		this.gstnRegistrationDt = gstnRegistrationDt;
	}

	public String getOrganizationStatus() {
		return organizationStatus;
	}

	public void setOrganizationStatus(String organizationStatus) {
		this.organizationStatus = organizationStatus;
	}

	@Override
	public String toString() {
		return "OrganizationDetailsResponseVO [organizationId=" + organizationId + ", legalName=" + legalName
				+ ", tradeName=" + tradeName + ", panNumber=" + panNumber + ", commencementDt=" + commencementDt
				+ ", gstnRegistrationDt=" + gstnRegistrationDt + ", organizationStatus=" + organizationStatus
				+ ", addressDetails=" + addressDetails + "]";
	}	
	
}
