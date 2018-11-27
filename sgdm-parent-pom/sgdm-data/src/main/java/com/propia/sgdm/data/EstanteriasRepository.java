package com.propia.sgdm.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "estanteriaDto", path = "estanteria")
public interface EstanteriasRepository extends CrudRepository<EstanteriaDto, Integer>{
	
	
	Optional<EstanteriaDto> findByNombre(String nonmbre);
	List<EstanteriaDto> findAll();
	Optional<EstanteriaDto> findById(Integer id);
	
	
	
	
}


