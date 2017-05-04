package com.gsp.mastek.registration.vo;

import java.util.Set;

public class OrganizationGstnResponseVO {

	private Long organizationId;
	
	/*@JsonProperty("gstnregistrationDtls")*/
	private Set<GstnregistrationDtlsVO> GstnregistrationDtlses;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Set<GstnregistrationDtlsVO> getGstnregistrationDtlses() {
		return GstnregistrationDtlses;
	}

	public void setGstnregistrationDtlses(Set<GstnregistrationDtlsVO> gstnregistrationDtlses) {
		GstnregistrationDtlses = gstnregistrationDtlses;
	}

	@Override
	public String toString() {
		return "OrganizationGstnResponseVO [organizationId=" + organizationId + ", GstnregistrationDtlses="
				+ GstnregistrationDtlses + "]";
	}

	
}
