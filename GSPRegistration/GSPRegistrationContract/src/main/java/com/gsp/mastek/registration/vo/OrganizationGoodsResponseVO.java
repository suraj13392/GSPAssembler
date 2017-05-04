package com.gsp.mastek.registration.vo;

import java.util.Set;

public class OrganizationGoodsResponseVO {

	private Long organizationId;
	
	private Set<GoodsDtlsVO> goodsDetails ;
	
	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Set<GoodsDtlsVO> getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(Set<GoodsDtlsVO> goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	@Override
	public String toString() {
		return "OrganizationGoodsResponseVO [organizationId=" + organizationId + ", goodsDetails=" + goodsDetails + "]";
	}
	
	
}
