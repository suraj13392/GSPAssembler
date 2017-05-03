package com.gsp.mastek.registration.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.registration.model.GoodsDtls;

@RepositoryRestResource(exported=false)
public interface GoodsDtlsRepository extends CrudRepository<GoodsDtls, Long> {
	@Query("FROM GoodsDtls gd  join fetch  gd.organization as o where o.organizationId = :organizationId")
	Set<GoodsDtls> findByOrganizationId(@Param("organizationId")Long organizationId);
}
