package com.propia.sgdm.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "articuloDto", path = "articulo")
public interface ArticulosRepository extends CrudRepository<ArticuloDto, Integer>{
	
	Optional<ArticuloDto> findById(Integer id);
	Optional<ArticuloDto> findByNombre(String nonmbre);
	List<ArticuloDto> findAll();
	
	
}


