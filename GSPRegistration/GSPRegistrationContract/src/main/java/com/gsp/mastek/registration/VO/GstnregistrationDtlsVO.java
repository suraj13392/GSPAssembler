package com.gsp.mastek.registration.VO;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import com.gsp.mastek.common.vo.BaseVO;

/**
 * GstnregistrationDtls generated by hbm2java
 */

public class GstnregistrationDtlsVO extends BaseVO {

	private Long gstnregistrationdtlsId;
    private String stateCd;
	private String gstin;
	
	public Long getGstnregistrationdtlsId() {
		return gstnregistrationdtlsId;
	}
	public void setGstnregistrationdtlsId(Long gstnregistrationdtlsId) {
		this.gstnregistrationdtlsId = gstnregistrationdtlsId;
	}
	public String getStateCd() {
		return stateCd;
	}
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	
	@Override
	public String toString() {
		return "GstnregistrationDtls [gstnregistrationdtlsId=" + gstnregistrationdtlsId + ", stateCd=" + stateCd
				+ ", gstin=" + gstin + "]";
	}

}