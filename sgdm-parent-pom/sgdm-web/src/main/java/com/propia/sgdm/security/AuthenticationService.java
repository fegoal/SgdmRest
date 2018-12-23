package com.propia.sgdm.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.propia.sgdm.service.UserService;
import com.propia.sgdm.service.bean.UserBean;

@Service
public class AuthenticationService implements UserDetailsService {
	
		@Autowired
		private UserService service;

		private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			LOG.debug("Trying to authenticate to {}", userName);
			UserBean user = service.findByUsername(userName);
			if (user == null) {
				throw new UsernameNotFoundException("Username " + userName + " not found");
			} else {
				Collection<? extends GrantedAuthority> authorities = getGrantedAuthorities(user);
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
			}
		}

		private Collection<? extends GrantedAuthority> getGrantedAuthorities(UserBean user) {
			List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
			list.add(new GrantedAuthority() {
				private static final long serialVersionUID = 2409931876244987359L;

				@Override
				public String getAuthority() {
					return user.getRole().getName();
				}
			});
			return list;
		}

		
	}
