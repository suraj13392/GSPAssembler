package com.gsp.mastek.registration.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.registration.model.GoodsDtls;
import com.gsp.mastek.registration.model.ServiceDtls;

@RepositoryRestResource(exported=false)
public interface ServiceDtlsRepository extends CrudRepository<ServiceDtls, Long> {
	@Query("FROM ServiceDtls sd  join fetch  sd.organization as o where o.organizationId = :organizationId")
	Set<ServiceDtls> findByOrganizationId(@Param("organizationId")Long organizationId);
}
