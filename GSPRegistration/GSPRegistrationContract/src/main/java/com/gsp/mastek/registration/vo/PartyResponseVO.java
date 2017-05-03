package com.gsp.mastek.registration.vo;

import java.util.List;

public class PartyResponseVO {
	private OrganizationVO organizationDetails ;

	public OrganizationVO getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationVO organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	@Override
	public String toString() {
		return "PartyResponse [organizationDetails=" + organizationDetails
				+ "]";
	}
}
