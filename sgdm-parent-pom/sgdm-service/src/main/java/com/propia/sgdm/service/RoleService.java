package com.propia.sgdm.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.propia.sgdm.service.bean.RoleBean;

public interface RoleService {
	
	List<RoleBean> findAll();
	public RoleBean findOne(Integer idRole) throws ServiceException;
	

}
