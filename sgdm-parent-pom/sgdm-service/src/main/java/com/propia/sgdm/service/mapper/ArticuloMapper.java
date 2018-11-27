package com.propia.sgdm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.propia.sgdm.data.ArticuloDto;
import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.service.bean.ArticuloBean;
import com.propia.sgdm.service.bean.EstanteriaBean;

@Mapper(componentModel = "spring")
public interface ArticuloMapper {
	
	@Mapping(target = "id", source = "ident")
	ArticuloDto toDto(final ArticuloBean bean);
	
	@Mapping(target = "id", source = "ident")
	EstanteriaDto toDto(final EstanteriaBean bean);
	
	List<ArticuloDto> toDto(final List<ArticuloBean> bean);
	
	@Mapping(target = "ident", source = "id")
	ArticuloBean toBean(final ArticuloDto dto);
	
	@Mapping(target = "ident", source = "id")
	EstanteriaBean toBean(final EstanteriaDto dto);
	
	List<ArticuloBean> toBean(final List<ArticuloDto> dto);


}
