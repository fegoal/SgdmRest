package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.Optional;

import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.service.bean.EstanteriaBean;


public interface EstanteriaMapper {
	

	EstanteriaDto toDto(final EstanteriaBean bean);
	EstanteriaBean toBean(final EstanteriaDto dto);
	Optional<EstanteriaDto> toDto(final Optional<EstanteriaBean> bean);
	Optional<EstanteriaBean> toBean(final Optional<EstanteriaDto> dto);

	List<EstanteriaDto> toDto(final List<EstanteriaBean> bean);
	List<EstanteriaBean> toBean(final List<EstanteriaDto> dto);

}
