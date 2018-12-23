package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.Optional;

import com.propia.sgdm.data.ArticuloDto;
import com.propia.sgdm.service.bean.ArticuloBean;


public interface ArticuloMapper {
	

	ArticuloDto toDto(final ArticuloBean bean);
	Optional<ArticuloDto> toDto(final Optional<ArticuloBean> bean);
	ArticuloBean toBean(final ArticuloDto dto);
	Optional<ArticuloBean> toBean(final Optional<ArticuloDto> dto);
	List<ArticuloDto> toDto(final List<ArticuloBean> bean);
	List<ArticuloBean> toBean(final List<ArticuloDto> dto);


}
