package com.gsp.mastek.registration.vo;

import java.util.Set;

public class OrganizationServiceResponseVO {

	private Long organizationId;
	private Set<ServiceDtlsVO> serviceDetails ;
	
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public Set<ServiceDtlsVO> getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(Set<ServiceDtlsVO> serviceDetails) {
		this.serviceDetails = serviceDetails;
	}
	
	@Override
	public String toString() {
		return "OrganizationServiceResponseVO [organizationId=" + organizationId + ", serviceDetails=" + serviceDetails
				+ "]";
	}
}
