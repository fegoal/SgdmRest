package com.propia.sgdm.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.propia.sgdm.service.ArticulosService;
import com.propia.sgdm.service.bean.ArticuloBean;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/articulos")
@Api(value = "ARTICULOS microserviceAPI: Expone recursos Articulos, Estanterias", consumes = "consumes=\"application/json", produces = "consumes=\"application/json")
public class ArticulosRestControllerImpl implements ArticulosRestController {

	Logger logger = LoggerFactory.getLogger(ArticulosRestControllerImpl.class);

	private ObjectMapper jsonMapper;
	private ArticulosService service;

	@Override
	public void delete(@PathVariable("id") String id) {
			logger.debug("/articulos - [deleteArticulo] - DELETE: id:" + id);
			service.delete(id);
	}

	@Override
	public Resource<ArticuloBean> add(@RequestBody ArticuloBean articuloBean) {
		logger.debug("/articulos - [insertArticulo] - POST:" + articuloBean.toString());
		return addLink(service.add(articuloBean));
	}

	@Override
	public Resource<ArticuloBean> update(@RequestBody ArticuloBean articuloBean, @PathVariable("id") String id) {
		
		logger.debug("/articulos/{id} - [updateArticulo] - PUT:" + articuloBean.toString());
		Optional<ArticuloBean> bean = service.update(id, articuloBean);
		return addLink(bean);
	}

	@Override
	public Resource<ArticuloBean> update(@RequestBody ArticuloBean articuloBean, @PathVariable("id") String id,@PathVariable("id_estanteria") String id_estanteria) {
		
		ArticuloBean bean = service.update(id, articuloBean, id_estanteria).orElseThrow(
				() -> new ResourceNotFoundException("Articulo/Estantería no encontrado - no update."));
		return addLink(bean);
	}

	@Override
	public Resources<Resource<ArticuloBean>> getAll() {
		logger.debug("/articulos - [getAll] - GET:");
		return this.addLinks(service.getAll());
	}

	@Override
	public Resource<ArticuloBean> getByIdent(@PathVariable("id") String id) {

		logger.debug("/articulos - [getByIde] - GET:" + "id:" + id);
		return addLink(service.getByIdent(id));
	}

	@Override
	public Resource<ArticuloBean> getByName(String nombre) {
		logger.debug("/articulos - [getByName] - GET:" + "name:" + nombre);
		return addLink(service.getByNombre(nombre));
	}
	
	
	
	
	
	
	
	
	
	
	private Resource<ArticuloBean> addLink(ArticuloBean bean) {
		Link link2 = null;
		Resource<ArticuloBean> resBean = new Resource<ArticuloBean>(bean);
		if (null != bean && null != bean.getEstanteria()) {
			link2 = linkTo(methodOn(EstanteriasRestControllerImpl.class).getByIdent(bean.getEstanteria().getIdent().toString())).withRel("estanterias");
			resBean.add(link2);
		
		}
		Link link = linkTo(methodOn(ArticulosRestControllerImpl.class).getByIdent(bean.getIdent().toString())).withSelfRel();
		resBean.add(link);
		return resBean;
	}
	
	private Resource<ArticuloBean> addLink(Optional<ArticuloBean> bean) {
		return this.addLink(bean.get());
	}
	
	private Resources<Resource<ArticuloBean>> addLinks(List<ArticuloBean> beans) {
		List<Resource<ArticuloBean>> al = new ArrayList<Resource<ArticuloBean>>();
		for(ArticuloBean bean: beans) {
			al.add(addLink(bean));
		}
		return new Resources<>(al);
	}
	
	public ObjectMapper getJsontMapper() {
		return jsonMapper;
	}

	@Autowired
	public void setJsontMapper(ObjectMapper jsontMapper) {
		this.jsonMapper = jsontMapper;
	}

	public ArticulosService getService() {
		return service;
	}

	@Autowired
	public void setService(ArticulosService service) {
		this.service = service;
	}



}
