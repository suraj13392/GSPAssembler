package com.gsp.mastek.registration.vo;

import java.util.List;

public class OrganizationAddressResponseVO {
	
	private Long organizationId;
	
	private List<OrganizationAddressVO> addressDetails ;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	
	public List<OrganizationAddressVO> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(List<OrganizationAddressVO> addressDetails) {
		this.addressDetails = addressDetails;
	}

	@Override
	public String toString() {
		return "OrganizationContactResponseVO [organizationId=" + organizationId + ", addressDetails=" + addressDetails
				+ "]";
	}

}
