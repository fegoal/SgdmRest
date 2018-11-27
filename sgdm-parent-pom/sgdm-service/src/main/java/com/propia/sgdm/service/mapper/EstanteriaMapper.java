package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.service.bean.EstanteriaBean;

@Mapper(componentModel = "spring")
public interface EstanteriaMapper {
	
	@Mapping(target = "id", source = "ident")
	EstanteriaDto toDto(final EstanteriaBean bean);
	
	@Mapping(target = "ident", source = "id")
	EstanteriaBean toBean(final EstanteriaDto dto);

	List<EstanteriaDto> toDto(final List<EstanteriaBean> bean);

	List<EstanteriaBean> toBean(final List<EstanteriaDto> dto);

}
