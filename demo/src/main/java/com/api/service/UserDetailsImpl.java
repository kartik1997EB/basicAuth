package com.api.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.api.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;



	@JsonIgnore
	private String password;

	public UserDetailsImpl() {

	}

	public UserDetailsImpl(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();;
		this.authorities =  Arrays.asList( new SimpleGrantedAuthority("ROLE_"+user.getRole()));
	}

	private Collection<? extends GrantedAuthority> authorities;

//	public UserDetailsImpl(Long id, String username, String email, String password) {
//		this.id = id;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.authorities = authorities;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}



}