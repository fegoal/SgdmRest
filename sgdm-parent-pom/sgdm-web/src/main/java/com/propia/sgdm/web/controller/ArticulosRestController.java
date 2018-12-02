package com.propia.sgdm.web.controller;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.propia.sgdm.service.bean.ArticuloBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ARTICULOS microservice", description = "API to manage Articulos")
public interface ArticulosRestController {
	
	@GetMapping(path="/", produces = "application/json")
	@ApiOperation(value = "Obtiene todos Articulos", notes = "Return una lista de articulos" )
	Resources<Resource<ArticuloBean>> getAll();
	
	@GetMapping(path="/{id}", produces = "application/json")
	@ApiOperation(value = "Busca un articulo por su id", notes = "Return un articulo" )
	Resource<ArticuloBean> getByIdent(@PathVariable("id") String id);
	
	@GetMapping(path="", produces = "application/json")
	@ApiOperation(value = "Busca un articulo por su nombre", notes = "Return un articulo" )
	Resource<ArticuloBean> getByName(@RequestParam("nombre") String name);

	
	@PutMapping(path="/{id}", consumes = "application/json", produces ="application/json")
	@ApiOperation(value = "Modifica un articulo dado su id", notes = "Return el articulo" )
	Resource<ArticuloBean> update(@RequestBody ArticuloBean articuloDto, @PathVariable("id") String id);
	
	@PutMapping(path="/{id}/estanterias/{id_estanteria}", consumes = "application/json", produces ="application/json")
	@ApiOperation(value = "Asocia un articulo a una estanteria", notes = "Return el articulo" )
	Resource<ArticuloBean> update(@RequestBody ArticuloBean articuloDto, @PathVariable("id") String id, @PathVariable("id_estanteria") String id_estanteria);
	
	@PostMapping(path="/", consumes = "application/json", produces ="application/json")
	@ApiOperation(value = "Añade un articulo", notes = "Return el articulo" )
	Resource<ArticuloBean> add(@RequestBody ArticuloBean articuloDto);
	
	@DeleteMapping(path="/{id}")
	@ApiOperation(value = "Elimina un articulo", notes = "" )
	void delete(@PathVariable("id") String id);
	

}
