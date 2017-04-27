package com.gsp.mastek.registration.vo;

import java.util.List;

public class OrganizationContactResponseVO {
	
	private Long organizationId;
	
	private List<OrganizationContactVO> contactDetails ;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public List<OrganizationContactVO> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<OrganizationContactVO> contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public String toString() {
		return "OrganizationContactResponseVO [organizationId=" + organizationId + ", contactDetails=" + contactDetails
				+ "]";
	}

}
