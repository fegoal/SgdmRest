package com.propia.sgdm.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.propia.sgdm.data.RoleDto;
import com.propia.sgdm.data.RoleRepository;
import com.propia.sgdm.service.bean.RoleBean;
import com.propia.sgdm.service.mapper.RoleMapper;


@Service
public class RoleServiceImpl implements RoleService {
	
	private static final long serialVersionUID = 8500967638946229530L;
	
	@Autowired
	private RoleRepository repository;
	private RoleMapper mapper;


	@Override
	public List<RoleBean> findAll() {
		List<RoleDto> roles = Lists.newArrayList(repository.findAll());
		return mapper.toBean(roles);
	}
	
	@Override
	public RoleBean findOne(Integer idRole) throws ServiceException {
		Optional<RoleDto> dto = repository.findById(idRole);
		if (dto != null) {
			return mapper.toBean(dto.get());
		} else {
			throw new ServiceException("NO ENCONTRADO EL USUARIO");
		}
	}
	
	
	public RoleRepository getRepository() {
		return repository;
	}
	@Autowired
	public void setRepository(RoleRepository repository) {
		this.repository = repository;
	}

	public RoleMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(RoleMapper mapper) {
		this.mapper = mapper;
	}

	
	
	





}
