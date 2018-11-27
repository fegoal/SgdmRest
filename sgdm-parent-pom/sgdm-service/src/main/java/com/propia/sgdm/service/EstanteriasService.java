package com.propia.sgdm.service;

import java.util.List;
import java.util.Optional;

import com.propia.sgdm.service.bean.EstanteriaBean;


public interface EstanteriasService {
	
	EstanteriaBean add(EstanteriaBean estanteria);

	List<EstanteriaBean> getAll();

	Optional<EstanteriaBean> getByIdent(String id);
	
	Optional<EstanteriaBean> getByNombre(String nombre);

	Optional<EstanteriaBean> update(String id, EstanteriaBean estanteria);

	void delete(String id);
	

}
