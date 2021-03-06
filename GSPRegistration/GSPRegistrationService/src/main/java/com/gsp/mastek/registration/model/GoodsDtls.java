package com.gsp.mastek.registration.model;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

import com.gsp.mastek.common.entity.BaseEntity;

/**
 * GoodsDtls generated by hbm2java
 */
@Entity
@Audited
public class GoodsDtls extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long goodsdtlsId;
	
	@OneToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId", referencedColumnName = "organizationId")
	private Organization organization;
	
	private String goodsDescription;
	
	private String hsnCode;

	public Long getGoodsdtlsId() {
		return goodsdtlsId;
	}

	public void setGoodsdtlsId(Long goodsdtlsId) {
		this.goodsdtlsId = goodsdtlsId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	@Override
	public String toString() {
		return "GoodsDtls [goodsdtlsId=" + goodsdtlsId + ", organization=" + organization + ", goodsDescription="
				+ goodsDescription + ", hsnCode=" + hsnCode + "]";
	}

}
