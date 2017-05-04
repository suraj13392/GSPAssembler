package com.gsp.mastek.registration.model;
// Generated 24 Apr, 2017 3:18:39 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.gsp.mastek.common.entity.BaseEntity;

/**
 * Organization generated by hbm2java
 */
@Entity
@Audited
public class Organization extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long organizationId;	
	
	private String legalName;
	
	private String tradeName;
	
	private String panNumber;
	
	@Temporal(TemporalType.DATE)
	private Date commencementDt;
	
	@Temporal(TemporalType.DATE)
	private Date gstnRegistrationDt;
	
	private String organizationStatus;
	
	@OneToOne(mappedBy = "organization", cascade = { CascadeType.DETACH})
	private BusinessDtls businessDtls;
	
	@NotAudited
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId", referencedColumnName = "organizationId")
	private Set<OrganizationAddress> organizationAddresses;
	
	@NotAudited
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId", referencedColumnName = "organizationId")
	private Set<GstnregistrationDtls> gstnregistrationDtlses;
	
	@NotAudited
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "membership", joinColumns = @JoinColumn(name = "organizationId", referencedColumnName = "organizationId"), inverseJoinColumns = @JoinColumn(name = "partyId", referencedColumnName = "partyId", unique = false))
	private Set<Party> parties;
	
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

	public BusinessDtls getBusinessDtls() {
		return businessDtls;
	}

	public void setBusinessDtls(BusinessDtls businessDtls) {
		this.businessDtls = businessDtls;
	}

	public Set<OrganizationAddress> getOrganizationAddresses() {
		return organizationAddresses;
	}

	public void setOrganizationAddresses(Set<OrganizationAddress> organizationAddresses) {
		this.organizationAddresses = organizationAddresses;
	}	
	
	public Set<Party> getParties() {
		return parties;
	}

	public void setParties(Set<Party> parties) {
		this.parties = parties;
	}

	public void addOrganizationAddress(OrganizationAddress organizationAddress) {
		if (this.organizationAddresses == null) {
			this.organizationAddresses = new HashSet<OrganizationAddress>();
			this.organizationAddresses.add(organizationAddress);
		} else {
			this.organizationAddresses.add(organizationAddress);
		}
	}
	
	public void addParty(Party party) {
		if (this.parties == null) {
			this.parties = new HashSet<Party>();
			this.parties.add(party);
		} else {
			this.parties.add(party);
		}
	}
	
	public void GstnregistrationDtls(GstnregistrationDtls gstnregistrationDtls) {
		if (this.gstnregistrationDtlses == null) {
			this.gstnregistrationDtlses = new HashSet<GstnregistrationDtls>();
			this.gstnregistrationDtlses.add(gstnregistrationDtls);
		} else {
			this.gstnregistrationDtlses.add(gstnregistrationDtls);
		}
	}

	public Set<GstnregistrationDtls> getGstnregistrationDtlses() {
		return gstnregistrationDtlses;
	}

	public void setGstnregistrationDtlses(Set<GstnregistrationDtls> gstnregistrationDtlses) {
		this.gstnregistrationDtlses = gstnregistrationDtlses;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", legalName=" + legalName + ", tradeName="
				+ tradeName + ", panNumber=" + panNumber + ", commencementDt=" + commencementDt
				+ ", gstnRegistrationDt=" + gstnRegistrationDt + ", organizationStatus=" + organizationStatus
				+ ", businessDtls=" + businessDtls + ", organizationAddresses=" + organizationAddresses
				+ ", gstnregistrationDtlses=" + gstnregistrationDtlses + ", parties=" + parties + "]";
	}	
}
