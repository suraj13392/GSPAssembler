package com.gsp.mastek.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.registration.model.GoodsDtls;

@RepositoryRestResource(exported=false)
public interface GoodsDtlsRepository extends CrudRepository<GoodsDtls, Long> {

}
