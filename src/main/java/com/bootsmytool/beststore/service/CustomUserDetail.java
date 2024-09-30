package com.bootsmytool.beststore.service;

import java.util.Collection;
import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bootsmytool.beststore.models.User;

public class CustomUserDetail implements UserDetails{

	private User user;
	
	public CustomUserDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(() -> user.getRole());
	}
	
	public String getFullname() {
		return user.getFullname();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override 
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override 
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override 
	public boolean isEnabled() {
		return true;
	}

}
