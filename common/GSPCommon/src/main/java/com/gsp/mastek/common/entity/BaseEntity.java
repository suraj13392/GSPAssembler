package com.gsp.mastek.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
//import javax.servlet.http.HttpServletRequest;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/*import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;*/

import com.fasterxml.jackson.annotation.JsonIgnore;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity{

	@Column(name = "created_by", nullable = true)
	@CreatedBy
	private String createdBy;

	@Column(name = "created_dt", nullable = true)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDt;

	@Column(name = "updated_by", nullable = true)
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "updated_dt", nullable = true)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDt;
	
    private Long requestId;
	
	private Long activityId;

	@PrePersist
	public void prePersist() throws Exception {
		this.createdBy = getUsernameOfAuthenticatedUser();
		;
		this.createdDt = new Date();
	}

	@PreUpdate
	public void preUpdate() throws Exception {
		this.updatedBy = getUsernameOfAuthenticatedUser();
		;
		this.updatedDt = new Date();
	}

	private String getUsernameOfAuthenticatedUser() {

		/*try {
			if (!(RequestContextHolder.currentRequestAttributes() instanceof ServletRequestAttributes)) {
				return "System";
			}
		} catch (IllegalStateException e) {
			return "System";
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		if (request == null || request.getHeader("X-EMAIL") == null) {
			return "System";
		}

		String username = request.getHeader("X-EMAIL");
		return username;*/
		
		return "System";
	}

	@JsonIgnore
	public String getAuthUserId() {
		return getUsernameOfAuthenticatedUser();
	}

	@JsonIgnore
	public String getSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@JsonIgnore
	public Date getUpdatedDt() {
		return updatedDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
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
		return "BaseEntity [createdBy=" + createdBy + ", createdDt=" + createdDt + ", updatedBy=" + updatedBy
				+ ", updatedDt=" + updatedDt + ", requestId=" + requestId + ", activityId=" + activityId + "]";
	}

}
