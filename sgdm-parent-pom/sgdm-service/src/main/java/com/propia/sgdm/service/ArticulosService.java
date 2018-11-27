package com.propia.sgdm.service;

import java.util.List;
import java.util.Optional;

import com.propia.sgdm.service.bean.ArticuloBean;

public interface ArticulosService {
	
	ArticuloBean add(ArticuloBean articulo);

	List<ArticuloBean> getAll();

	Optional<ArticuloBean> getByIdent(String id);
	
	Optional<ArticuloBean> getByNombre(String nombre);

	Optional<ArticuloBean> update(String id, ArticuloBean articulo);
	
	Optional<ArticuloBean> update(String id, ArticuloBean articulo, String id_estanteria);

	void delete(String id);
	

}
