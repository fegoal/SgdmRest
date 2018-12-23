package com.propia.sgdm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.data.RoleDto;
import com.propia.sgdm.data.UserDto;
import com.propia.sgdm.service.bean.EstanteriaBean;
import com.propia.sgdm.service.bean.RoleBean;
import com.propia.sgdm.service.bean.UserBean;

public interface UserMapper {
	
	UserDto toDto(UserBean bean);
	UserBean toBean(UserDto dto);
	List<UserBean> toBean(final List<UserDto> dto);


}
