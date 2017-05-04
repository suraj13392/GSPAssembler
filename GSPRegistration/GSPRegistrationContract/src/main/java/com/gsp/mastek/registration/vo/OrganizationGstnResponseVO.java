package com.gsp.mastek.registration.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationGstnResponseVO {

	private Long organizationId;
	
	@JsonProperty("GstnregistrationDtls")
	private List<GstnregistrationDtlsVO> GstnregistrationDtlses;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public List<GstnregistrationDtlsVO> getGstnregistrationDtlses() {
		return GstnregistrationDtlses;
	}

	public void setGstnregistrationDtlses(List<GstnregistrationDtlsVO> gstnregistrationDtlses) {
		GstnregistrationDtlses = gstnregistrationDtlses;
	}

	@Override
	public String toString() {
		return "OrganizationGstnResponseVO [organizationId=" + organizationId + ", GstnregistrationDtlses="
				+ GstnregistrationDtlses + "]";
	}
	
	
}
