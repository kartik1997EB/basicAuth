package com.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.model.User;
import com.api.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	@Autowired
	UserRepository userRepositoy;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("hi getting user name is "+username);
		User user =userRepositoy.findByUsername(username);
		System.out.println(user);
		if(user!=null)
			return new UserDetailsImpl(user);
		else {
			User u = new User();
			u.setUsername("lskaddlksdaljsdlksal");
			u.setPassword("ksdddddddddddksdksdksd");
			return new UserDetailsImpl(u);
		}
	}

}
