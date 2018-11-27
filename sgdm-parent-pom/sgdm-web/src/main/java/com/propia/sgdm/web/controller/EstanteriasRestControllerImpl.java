package com.propia.sgdm.web.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.propia.sgdm.service.EstanteriasService;
import com.propia.sgdm.service.bean.EstanteriaBean;

@RestController
@RequestMapping("/estanterias")
public class EstanteriasRestControllerImpl implements EstanteriasRestController{
	
	Logger logger = LoggerFactory.getLogger(EstanteriasRestControllerImpl.class);
	
	private ObjectMapper jsonMapper;
	private EstanteriasService service;
	
	@Override
	public void delete(@PathVariable("id") String id) {
		try {
			logger.debug("/estanterias - [deleteEstanteria] - DELETE: id:"+ id);
			service.delete(id);
		} catch (Exception e) {	e.printStackTrace(); }
	}
	
	@Override
	public EstanteriaBean add(@RequestBody EstanteriaBean estanteriaBean) {
//		try {
//			logger.debug("/estanterias - [insertEstanteria] - POST:"+ jsonMapper.writeValueAsString(estanteriaBean));
//		} catch (JsonProcessingException e) {	e.printStackTrace(); }
		
		return service.add(estanteriaBean);
	}
	
	
	@Override
	public List<EstanteriaBean> getAll() {
		
		try {
			logger.debug("/estanterias - [getAll] - GET:");
			return service.getAll();
		} catch (Exception e) {	e.printStackTrace(); }

		return null;
	}
	
	
	@Override
	public EstanteriaBean getByIdent(@PathVariable("id") String id) {

		logger.debug("/estanterias - [getByIde] - GET:" + "id:" + id);
			Optional<EstanteriaBean> bean = service.getByIdent(id);
			if(!bean.isPresent())
				throw new ResourceNotFoundException("Estantería no encontrada");
			return bean.get();
	}
	

	@Override
	public EstanteriaBean update(@RequestBody EstanteriaBean estanteriaBean, @PathVariable("id") String id) {
		logger.debug("/estanterias/{id} - [updateEstanteria] - PUT:"+ estanteriaBean.toString() + "id:" + id);
		Optional<EstanteriaBean> bean = service.update(id, estanteriaBean);
		if(!bean.isPresent())
			throw new ResourceNotFoundException("Estantería no encontrada");
		return bean.get();
	}
	
	

	public EstanteriasService getService() {
		return service;
	}

	@Autowired
	public void setService(EstanteriasService service) {
		this.service = service;
	}

	


	










	
	

}
