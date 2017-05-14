package com.monitor.security.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monitor.mapper.ManagerMapper;
import com.monitor.security.entity.ManagerUser;
import com.monitor.security.entity.ManagerUserInfoDetails;

@Service("userDetailsService")
public class ManagerUserInfoDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ManagerUser user = new ManagerUser();
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("username", username);
			user = managerMapper.selectManagerUserByNickname(map);
		} catch (Exception e) {
			throw new RuntimeException("user select fail");
		}
		
		if(null == user){
			throw new RuntimeException("no user");
		}
        
		ManagerUserInfoDetails uid = new ManagerUserInfoDetails(user.getmNickname(), user.getmPassword(), authorities);
		uid.setUser(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(uid, null, uid.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return uid;
	}

}
