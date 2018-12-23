package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.propia.sgdm.data.RoleDto;
import com.propia.sgdm.service.bean.RoleBean;


@Component
public class RoleMapperImpl implements RoleMapper {
	
	
	public RoleDto toDto(final RoleBean bean) {
		RoleDto dto = null;
		if(null != bean) {
			dto  = new RoleDto();
			dto.setDescription(bean.getDescription());
			dto.setIdRole(bean.getIdRole());
			dto.setName(bean.getName());
		}
		return dto;
	}
	
	public RoleBean toBean(final RoleDto dto) {
		RoleBean bean = null;
		if(null != dto) {
			bean = new RoleBean();
			bean.setDescription(dto.getDescription());
			bean.setIdRole(dto.getIdRole());
			bean.setName(dto.getName());
		}
		return bean;
	}

	public List<RoleDto> toDto(final List<RoleBean> bean){
		
		List<RoleDto> lstDto = null;
		lstDto = bean.stream().map((e) -> toDto(e)).collect(Collectors.toList());
		return lstDto;
	}

	public List<RoleBean> toBean(final List<RoleDto> dto){
		List<RoleBean> lstBean = null;
		lstBean = dto.stream().map((e) -> toBean(e)).collect(Collectors.toList());
		return lstBean;
	}

}
