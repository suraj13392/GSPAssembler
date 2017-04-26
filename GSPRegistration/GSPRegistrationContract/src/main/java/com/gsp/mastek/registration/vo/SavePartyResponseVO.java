package com.gsp.mastek.registration.vo;

import com.gsp.mastek.common.vo.BaseVO;

public class SavePartyResponseVO extends BaseVO{
	private OrganizationVO organizationDetails;

	public OrganizationVO getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationVO organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	@Override
	public String toString() {
		return "SavePartyRequestVO [organizationDetails=" + organizationDetails + "]";
	}
}
