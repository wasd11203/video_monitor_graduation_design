package com.monitor.security.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * extends org.springframework.security.core.userdetails.User:
 * 将User的实体的实现交由Spring Security 默认实现 extends SystemUser implements Userdetails:
 * 可以实现自定义User实体
 * 
 * @author 99
 *
 */
public class ManagerUserInfoDetails extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 577083631841600639L;

	private ManagerUser user;

	public ManagerUserInfoDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	/**
	 * @return the user
	 */
	public ManagerUser getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(ManagerUser user) {
		this.user = user;
	}

}
