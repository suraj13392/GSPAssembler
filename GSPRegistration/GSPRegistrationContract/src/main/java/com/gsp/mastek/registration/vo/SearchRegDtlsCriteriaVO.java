package com.gsp.mastek.registration.vo;

import com.gsp.mastek.common.vo.BaseVO;

public class SearchRegDtlsCriteriaVO extends BaseVO {
	
	private Long organizationId;
	private String gstin;
	private Long partyId;
	private String aadharNumber;
	private String panNumber;
	private String userName;
	private String partyStatus;
	
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public Long getPartyId() {
		return partyId;
	}
	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPartyStatus() {
		return partyStatus;
	}
	public void setPartyStatus(String partyStatus) {
		this.partyStatus = partyStatus;
	}
	@Override
	public String toString() {
		return "SearchRegDtlsCriteriaVO [organizationId=" + organizationId + ", gstin=" + gstin + ", partyId=" + partyId
				+ ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", userName=" + userName
				+ ", partyStatus=" + partyStatus + "]";
	}
	
	
}
