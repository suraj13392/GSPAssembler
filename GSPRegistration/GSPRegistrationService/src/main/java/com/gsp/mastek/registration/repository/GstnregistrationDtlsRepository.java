package com.gsp.mastek.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.registration.model.GstnregistrationDtls;

@RepositoryRestResource(exported=false)
public interface GstnregistrationDtlsRepository extends CrudRepository<GstnregistrationDtls, Long> {

}
