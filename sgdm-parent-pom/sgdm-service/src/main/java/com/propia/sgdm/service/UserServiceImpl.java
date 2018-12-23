package com.propia.sgdm.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.propia.sgdm.data.UserDto;
import com.propia.sgdm.data.UserRepository;
import com.propia.sgdm.service.bean.UserBean;
import com.propia.sgdm.service.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	private UserMapper mapper;

	private static final long serialVersionUID = 8500967638946229530L;

	@Override
	public List<UserBean> findAll() {
		List<UserDto> users = Lists.newArrayList(repository.findAll());
		return mapper.toBean(users);
	}
	
	
	@Override
	public UserBean findByUsername(String userName) {
		UserDto dto = repository.findByUsername(userName);
		if(null != dto) {
			return mapper.toBean(dto);
		}
		throw new ServiceException("NO ENCONTRADO EL USUARIO");
	}
	

	public UserRepository getRepository() {
		return repository;
	}
	@Autowired
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public UserMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}


}
