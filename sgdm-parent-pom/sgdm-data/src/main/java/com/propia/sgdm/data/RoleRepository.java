/**
 * 
 */
package com.propia.sgdm.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "roleDto", path = "role")
public interface RoleRepository extends CrudRepository<RoleDto, Integer>{

	Optional<RoleDto> findById(Integer id);
}
