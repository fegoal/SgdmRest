package com.propia.sgdm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propia.sgdm.data.ArticuloDto;
import com.propia.sgdm.data.ArticulosRepository;
import com.propia.sgdm.service.bean.ArticuloBean;
import com.propia.sgdm.service.bean.EstanteriaBean;
import com.propia.sgdm.service.errors.exceptions.ResourceNotFoundException;
import com.propia.sgdm.service.mapper.ArticuloMapper;


@Service
public class ArticulosServiceImpl implements ArticulosService {
	
	private static final String IGNORE_PROPERTIES  ="ident"; 
	private ArticulosRepository repository;
	private EstanteriasService estanteriasService;
	private ArticuloMapper mapper;
	

	@Override
	public ArticuloBean add(ArticuloBean articuloBean) {
		ArticuloDto art = mapper.toDto(articuloBean);
		return mapper.toBean(repository.save(art));
	}

	@Override
	public List<ArticuloBean> getAll() {
		return mapper.toBean(repository.findAll());
	}

	@Override
	public Optional<ArticuloBean> getByIdent(String id) {

		Optional<ArticuloDto> dto = repository.findById(Integer.parseInt(id));
		dto.orElseThrow(() -> new ResourceNotFoundException("ARTICULO NO ENCONTRADO"));
		return  mapper.toBean(dto);
	}
	
	@Override
	public Optional<ArticuloBean> update(String id, ArticuloBean articuloBean) {
		
		Optional<ArticuloBean> bean = this.getByIdent(id);
		bean.orElseThrow(() -> new ResourceNotFoundException("ARTICULO NO ENCONTRADO"));
		BeanUtils.copyProperties(articuloBean, bean.get(), IGNORE_PROPERTIES);
		repository.save(mapper.toDto(bean.get()));
		return bean;
	}
	
	@Override
	public Optional<ArticuloBean> update(String id, ArticuloBean articuloBean, String id_estanteria) {

		Optional<ArticuloBean> bean = this.getByIdent(id);
		Optional <EstanteriaBean> estanteriaBean  = estanteriasService.getByIdent(id_estanteria);
		bean.orElseThrow(() -> new ResourceNotFoundException("ARTICULO NO ENCONTRADO"));
		BeanUtils.copyProperties(articuloBean, bean.get(), IGNORE_PROPERTIES);
		bean.get().setEstanteria(estanteriaBean.get());
		repository.save(mapper.toDto(bean.get()));
		return bean;
	}

	
	@Override
	public Optional<ArticuloBean> getByNombre(String nombre) {
		
		Optional<ArticuloDto> dto  = repository.findByNombre(nombre);
		dto.orElseThrow(() -> new ResourceNotFoundException("ARTICULO NO ENCONTRADO"));
		return mapper.toBean(dto);
	}
	
	@Override
	public void delete(String id) {
		this.repository.deleteById(new Integer(id));
		
	}

	public ArticulosRepository getRepository() {
		return repository;
	}
	@Autowired
	public void setRepository(ArticulosRepository repository) {
		this.repository = repository;
	}

	public ArticuloMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(ArticuloMapper mapper) {
		this.mapper = mapper;
	}

	public EstanteriasService getEstanteriasService() {
		return estanteriasService;
	}

	@Autowired
	public void setEstanteriasService(EstanteriasService estanteriasService) {
		this.estanteriasService = estanteriasService;
	}

	
	





}
