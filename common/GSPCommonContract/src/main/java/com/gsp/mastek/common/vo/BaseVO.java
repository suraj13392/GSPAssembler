package com.gsp.mastek.common.vo;

public class BaseVO {
	
	private String createdBy;
	
	private Long requestId;
		
    private Long activityId;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	@Override
	public String toString() {
		return "BaseVO [createdBy=" + createdBy + ", requestId=" + requestId + ", activityId=" + activityId + "]";
	}
}
