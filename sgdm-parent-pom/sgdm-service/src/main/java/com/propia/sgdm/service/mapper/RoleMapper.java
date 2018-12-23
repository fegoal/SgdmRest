package com.propia.sgdm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.propia.sgdm.data.RoleDto;
import com.propia.sgdm.service.bean.RoleBean;




public interface RoleMapper {
	
	
	RoleDto toDto(final RoleBean bean);
	
	RoleBean toBean(final RoleDto dto);

	List<RoleDto> toDto(final List<RoleBean> bean);

	List<RoleBean> toBean(final List<RoleDto> dto);

}
