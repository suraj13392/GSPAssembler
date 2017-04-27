package com.gsp.mastek.registration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.registration.model.Organization;

@RepositoryRestResource(exported=false)
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
	
	@Query("FROM Organization o  left outer join  o.gstnregistrationDtlses as gr left outer join o.parties as p "
			+ "where o.organizationId = coalesce(:organizationId,o.organizationId) and "
			+ "o.panNumber = coalesce(:panNumber,o.panNumber) and gr.gstin = coalesce(:gstin,gr.gstin)  "
			+ "and p.aadharNumber = coalesce(:aadharNumber,p.aadharNumber) and "
			+ "p.lastName = coalesce(:userName,p.lastName) and "
			+ "p.partyId = coalesce(:partyId,p.partyId) and "
			+ "p.partyStatus = coalesce(:partyStatus,p.partyStatus)")
	Organization findBySearchCriteria(@Param("organizationId")Long organizationId,@Param("gstin") String gstin, @Param("aadharNumber")String aadharNumber, @Param("panNumber")String panNumber,
			@Param("partyId")Long partyId, @Param("partyStatus")String partyStatus, @Param("userName")String userName);
	


}
