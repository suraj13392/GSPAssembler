package com.gsp.mastek.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
//import javax.servlet.http.HttpServletRequest;

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

	@Column(name = "created_by_user", nullable = true)
	@CreatedBy
	private String createdByUser;

	@Column(name = "creation_date", nullable = true)
	@CreatedDate
	private Date creationDate;

	@Column(name = "modified_by_user", nullable = true)
	@LastModifiedBy
	private String modifiedByUser;

	@Column(name = "modification_date", nullable = true)
	@LastModifiedDate
	private Date modificationDate;

	@PrePersist
	public void prePersist() throws Exception {
		this.createdByUser = getUsernameOfAuthenticatedUser();
		;
		this.creationDate = new Date();
	}

	@PreUpdate
	public void preUpdate() throws Exception {
		this.modifiedByUser = getUsernameOfAuthenticatedUser();
		;
		this.modificationDate = new Date();
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
	public Date getModificationDate() {
		return modificationDate;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifiedByUser() {
		return modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

}
