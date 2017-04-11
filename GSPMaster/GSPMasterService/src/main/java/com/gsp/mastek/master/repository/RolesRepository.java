package com.gsp.mastek.master.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gsp.mastek.master.model.Roles;

@RepositoryRestResource(exported=false)
public interface RolesRepository extends CrudRepository<Roles, Long> {

}
