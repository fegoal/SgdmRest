package com.propia.sgdm.service;

import java.util.List;

import com.propia.sgdm.service.bean.UserBean;

public interface UserService {
	
	List<UserBean> findAll();
	UserBean findByUsername(String userName);
	

}
