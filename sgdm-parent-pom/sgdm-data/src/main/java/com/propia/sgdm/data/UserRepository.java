/**
 * 
 */
package com.propia.sgdm.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userDto", path = "usuario")
public interface UserRepository extends CrudRepository<UserDto, Integer> {
	
	UserDto findByUsername(String username);

}
