package com.gsp.mastek.registration.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.registration.model.Organization;

@RepositoryRestResource(exported=false)
public interface OrganizationRepository extends CrudRepository<Organization, Long>,JpaSpecificationExecutor<Organization> {
	
}
