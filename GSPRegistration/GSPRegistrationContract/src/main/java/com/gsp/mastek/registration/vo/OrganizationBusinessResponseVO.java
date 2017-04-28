package com.gsp.mastek.registration.vo;

public class OrganizationBusinessResponseVO {

	private Long organizationId;
	
	private BusinessDtlsVO businessDtls ;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}


	public BusinessDtlsVO getBusinessDtls() {
		return businessDtls;
	}

	public void setBusinessDtls(BusinessDtlsVO businessDtls) {
		this.businessDtls = businessDtls;
	}

	@Override
	public String toString() {
		return "OrganizationBusinessResponseVO [organizationId=" + organizationId + ", businessDtls=" + businessDtls
				+ "]";
	}
	
	
}
