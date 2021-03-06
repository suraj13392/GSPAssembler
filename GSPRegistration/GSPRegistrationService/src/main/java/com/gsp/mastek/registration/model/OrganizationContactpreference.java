package com.gsp.mastek.registration.model;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import com.gsp.mastek.common.entity.BaseEntity;

/**
 * OrganizationContactpreference generated by hbm2java
 */
@Entity
@Audited
public class OrganizationContactpreference extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long organizationcontactpreferenceId;
	
	private String preferredDay;
	
	private String preferredTimefrom;
	
	private String preferredTimeto;
	
	private Long contactId;

	public Long getOrganizationcontactpreferenceId() {
		return organizationcontactpreferenceId;
	}

	public void setOrganizationcontactpreferenceId(Long organizationcontactpreferenceId) {
		this.organizationcontactpreferenceId = organizationcontactpreferenceId;
	}

	public String getPreferredDay() {
		return preferredDay;
	}

	public void setPreferredDay(String preferredDay) {
		this.preferredDay = preferredDay;
	}

	public String getPreferredTimefrom() {
		return preferredTimefrom;
	}

	public void setPreferredTimefrom(String preferredTimefrom) {
		this.preferredTimefrom = preferredTimefrom;
	}

	public String getPreferredTimeto() {
		return preferredTimeto;
	}

	public void setPreferredTimeto(String preferredTimeto) {
		this.preferredTimeto = preferredTimeto;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "OrganizationContactpreference [organizationcontactpreferenceId=" + organizationcontactpreferenceId
				+ ", preferredDay=" + preferredDay + ", preferredTimefrom=" + preferredTimefrom + ", preferredTimeto="
				+ preferredTimeto + ", contactId=" + contactId + "]";
	}
}
