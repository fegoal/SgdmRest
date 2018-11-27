package com.propia.sgdm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.data.EstanteriasRepository;
import com.propia.sgdm.service.bean.EstanteriaBean;
import com.propia.sgdm.service.errors.exceptions.ResourceNotFoundException;
import com.propia.sgdm.service.mapper.EstanteriaMapper;
	


@Service
public class EstanteriasServiceImpl implements EstanteriasService {
	
	private static final String IGNORE_PROPERTIES  ="ident"; 
	private EstanteriasRepository repository;
	private EstanteriaMapper mapper;	

	@Override
	public EstanteriaBean add(EstanteriaBean estanteriaBean) {
		return mapper.toBean(this.repository.save(mapper.toDto(estanteriaBean)));
	}

	@Override
	public List<EstanteriaBean> getAll() {
		return mapper.toBean(this.repository.findAll());
	}

	@Override
	public Optional<EstanteriaBean> getByIdent(String id) {
		
		Optional<EstanteriaDto> dto = repository.findById(Integer.parseInt(id));
		dto.orElseThrow(() -> new ResourceNotFoundException("ESTANTERIA NO ENCONTRADO"));
		return  Optional.ofNullable(mapper.toBean(dto.get()));
	}
	
	@Override
	public Optional<EstanteriaBean> update(String id, EstanteriaBean estanteriaBean) {
		
		Optional<EstanteriaBean> bean = this.getByIdent(id);
		BeanUtils.copyProperties(estanteriaBean, bean.get(), IGNORE_PROPERTIES);
		this.repository.save(mapper.toDto(bean.get()));
		return bean;
	}
	
	@Override
	public Optional<EstanteriaBean> getByNombre(String nombre) {

		Optional<EstanteriaDto> dto = repository.findByNombre(nombre);
		dto.orElseThrow(() -> new ResourceNotFoundException("ESTANTERIA NO ANCONTRADA"));
		return Optional.ofNullable(mapper.toBean(dto.get()));
	}
	
	@Override
	public void delete(String id) {
		this.repository.deleteById(Integer.parseInt(id));
		
	}
	

	public EstanteriasRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(EstanteriasRepository repository) {
		this.repository = repository;
	}

	public EstanteriaMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(EstanteriaMapper mapper) {
		this.mapper = mapper;
	}





}
