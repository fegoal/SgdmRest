package com.propia.sgdm.service.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.propia.sgdm.data.ArticuloDto;
import com.propia.sgdm.data.EstanteriaDto;
import com.propia.sgdm.data.RoleDto;
import com.propia.sgdm.service.bean.ArticuloBean;
import com.propia.sgdm.service.bean.EstanteriaBean;
import com.propia.sgdm.service.bean.RoleBean;

@Component
public class ArticuloMapperImpl implements ArticuloMapper {

	@Autowired
	EstanteriaMapper mapper;
	
	@Override
	public ArticuloDto toDto(ArticuloBean bean) {
		ArticuloDto dto = null;
		EstanteriaBean estBean = null;
		
		if(bean != null) {
			dto = new ArticuloDto();
			if(null != bean.getIdent())
				dto.setId(new Integer(bean.getIdent()));
			estBean = bean.getEstanteria();
			if(null != estBean)	
				dto.setEstanteria(mapper.toDto(estBean));
			BeanUtils.copyProperties(bean, dto, "ident","estanteria");
		}
		return dto;
	}
	
	@Override
	public Optional<ArticuloDto> toDto(Optional<ArticuloBean> bean) {
		return Optional.ofNullable(toDto(bean.get()));
	}

	
	@Override
	public ArticuloBean toBean(ArticuloDto dto) {
		ArticuloBean bean = null;
		EstanteriaDto estDto = null;
		if(dto != null) {
			bean = new ArticuloBean();
			bean.setIdent(dto.getId().toString());
			estDto = dto.getEstanteria();
			if(null != estDto)	
				bean.setEstanteria(mapper.toBean(estDto));
			BeanUtils.copyProperties(dto, bean, "id","estanteria");
		}
		return bean;
	}
	
	@Override
	public Optional<ArticuloBean> toBean(Optional<ArticuloDto> dto) {
		return Optional.ofNullable(toBean(dto.get()));
	}

	@Override
	public List<ArticuloDto> toDto(List<ArticuloBean> bean) {
		List<ArticuloDto> lstDto = null;
		lstDto = bean.stream().map((e) -> toDto(e)).collect(Collectors.toList());
		return lstDto;
	}

	@Override
	public List<ArticuloBean> toBean(List<ArticuloDto> dto) {
		List<ArticuloBean> lstBean = null;
		lstBean = dto.stream().map((e) -> toBean(e)).collect(Collectors.toList());
		return lstBean;
	}


	


	

}
