package com.gsp.mastek.registration.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrganizationDetails{
	
	private OrganizationDetailsVO organizationDetails;
	private List<OrganizationAddressVO> addressDetails ;

	

	public List<OrganizationAddressVO> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(List<OrganizationAddressVO> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public OrganizationDetailsVO getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationDetailsVO organizationDetails) {
		this.organizationDetails = organizationDetails;
	}
	
	
}
