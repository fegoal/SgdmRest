package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.service.bean.EstanteriaBean;

@Component
public class EstanteriaMapperImpl implements EstanteriaMapper {

	@Override
	public EstanteriaDto toDto(EstanteriaBean bean) {
		EstanteriaDto dto = null;
		if(null != bean) {
			dto = new EstanteriaDto();
			dto.setId(new Integer(bean.getIdent()));
			BeanUtils.copyProperties(bean, dto, "ident");
		}
		return dto;
	}
	
	@Override
	public Optional<EstanteriaDto> toDto(Optional<EstanteriaBean> bean) {
		return Optional.ofNullable(toDto(bean.get()));
	}

	@Override
	public EstanteriaBean toBean(EstanteriaDto dto) {
		EstanteriaBean bean = null;
		if(null != dto) {
			bean = new EstanteriaBean();
			bean.setIdent(dto.getId().toString());
			BeanUtils.copyProperties(dto, bean,"id");
		}
		return bean;
	}
	
	@Override
	public Optional<EstanteriaBean> toBean(Optional<EstanteriaDto> dto) {
		return Optional.ofNullable(toBean(dto.get()));
	}
	
	@Override
	public List<EstanteriaBean> toBean(List<EstanteriaDto> dto) {
		List<EstanteriaBean> lstBeanss = null;
		lstBeanss = dto.stream().map((e) -> toBean(e)).collect(Collectors.toList());
		return lstBeanss;
	}

	@Override
	public List<EstanteriaDto> toDto(List<EstanteriaBean> bean) {
		List<EstanteriaDto> lstDtos = null;
		lstDtos = bean.stream().map((e) -> toDto(e)).collect(Collectors.toList());
		return lstDtos;
	}



}
