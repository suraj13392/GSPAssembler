package com.gsp.mastek.common.vo;

public class BaseVO {
	
	private String createdBy;	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "BaseVO [createdBy=" + createdBy + "]";
	}
	
}
