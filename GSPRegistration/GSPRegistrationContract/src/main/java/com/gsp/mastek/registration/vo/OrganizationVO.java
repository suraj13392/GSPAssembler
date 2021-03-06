package com.gsp.mastek.registration.vo;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsp.mastek.common.vo.BaseVO;

/**
 * Organization generated by hbm2java
 */

public class OrganizationVO extends BaseVO {

	private Long organizationId;
	private String legalName;
	private String tradeName;
	private String panNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "IST")
	private Date commencementDt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "IST")
	private Date gstnRegistrationDt;
	private String organizationStatus;
	private Set<PartyVO> parties = new HashSet<PartyVO>(0);
	private BusinessDtlsVO businessDtls ;	
	@JsonProperty("serviceDtls")
	private Set<ServiceDtlsVO> serviceDtlses = new HashSet<ServiceDtlsVO>(0);	
	@JsonProperty("gstnregistrationDtls")
	private Set<GstnregistrationDtlsVO> gstnregistrationDtlses = new HashSet<GstnregistrationDtlsVO>(0);	
	private Set<OrganizationAddressVO> organizationAddresses = new HashSet<OrganizationAddressVO>(0);	
	@JsonProperty("goodsDtls")
	private Set<GoodsDtlsVO> goodsDtlses = new HashSet<GoodsDtlsVO>(0);
	
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Date getCommencementDt() {
		return commencementDt;
	}
	public void setCommencementDt(Date commencementDt) {
		this.commencementDt = commencementDt;
	}
	public Date getGstnRegistrationDt() {
		return gstnRegistrationDt;
	}
	public void setGstnRegistrationDt(Date gstnRegistrationDt) {
		this.gstnRegistrationDt = gstnRegistrationDt;
	}
	public String getOrganizationStatus() {
		return organizationStatus;
	}
	public void setOrganizationStatus(String organizationStatus) {
		this.organizationStatus = organizationStatus;
	}
	public Set<PartyVO> getParties() {
		return parties;
	}
	public void setParties(Set<PartyVO> parties) {
		this.parties = parties;
	}	
	
	public BusinessDtlsVO getBusinessDtls() {
		return businessDtls;
	}
	public void setBusinessDtls(BusinessDtlsVO businessDtls) {
		this.businessDtls = businessDtls;
	}
	public Set<ServiceDtlsVO> getServiceDtlses() {
		return serviceDtlses;
	}
	public void setServiceDtlses(Set<ServiceDtlsVO> serviceDtlses) {
		this.serviceDtlses = serviceDtlses;
	}
	public Set<GstnregistrationDtlsVO> getGstnregistrationDtlses() {
		return gstnregistrationDtlses;
	}
	public void setGstnregistrationDtlses(Set<GstnregistrationDtlsVO> gstnregistrationDtlses) {
		this.gstnregistrationDtlses = gstnregistrationDtlses;
	}
	public Set<OrganizationAddressVO> getOrganizationAddresses() {
		return organizationAddresses;
	}
	public void setOrganizationAddresses(Set<OrganizationAddressVO> organizationAddresses) {
		this.organizationAddresses = organizationAddresses;
	}
	public Set<GoodsDtlsVO> getGoodsDtlses() {
		return goodsDtlses;
	}
	public void setGoodsDtlses(Set<GoodsDtlsVO> goodsDtlses) {
		this.goodsDtlses = goodsDtlses;
	}
	
	@Override
	public String toString() {
		return "OrganizationVO [organizationId=" + organizationId + ", legalName=" + legalName + ", tradeName="
				+ tradeName + ", panNumber=" + panNumber + ", commencementDt=" + commencementDt
				+ ", gstnRegistrationDt=" + gstnRegistrationDt + ", organizationStatus=" + organizationStatus
				+ ", parties=" + parties + ", businessDtlses=" + businessDtls + ", serviceDtlses=" + serviceDtlses
				+ ", gstnregistrationDtlses=" + gstnregistrationDtlses + ", organizationAddresses="
				+ organizationAddresses + ", goodsDtlses=" + goodsDtlses + "]";
	}
}
