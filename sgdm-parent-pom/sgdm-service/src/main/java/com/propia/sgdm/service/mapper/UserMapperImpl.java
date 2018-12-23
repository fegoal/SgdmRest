package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.propia.sgdm.data.UserDto;
import com.propia.sgdm.service.bean.UserBean;

@Component
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public UserDto toDto(UserBean bean) {
		UserDto dto = null;
		if(null != bean) {
			dto = new UserDto();
			BeanUtils.copyProperties(bean, dto);
			if(null != bean.getIdUser())
				dto.setIdUser(new Integer(bean.getIdUser()));
			if(null != bean.getRole())
				dto.setRole(roleMapper.toDto(bean.getRole()));
		}
		return dto;
	}

	@Override
	public UserBean toBean(UserDto dto) {
		UserBean bean = null;
		if(null != dto) {
			bean = new UserBean();
			BeanUtils.copyProperties(dto, bean);
			if(null != dto.getIdUser())
				bean.setIdUser(dto.getIdUser());
			if(null != dto.getRole())
				bean.setRole(roleMapper.toBean(dto.getRole()));
		}
		return bean;
	}

	@Override
	public List<UserBean> toBean(List<UserDto> dto) {
		List<UserBean> lstBeans = null;
		lstBeans = dto.stream().map((e) -> toBean(e)).collect(Collectors.toList());
		return lstBeans;
	}

}
