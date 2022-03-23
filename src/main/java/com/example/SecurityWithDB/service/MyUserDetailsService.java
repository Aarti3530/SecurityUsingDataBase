package com.example.SecurityWithDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.SecurityWithDB.service.UserPrincipal;
import com.example.SecurityWithDB.dao.UserRepository;
import com.example.SecurityWithDB.entity.User;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUsername(username);
		if(user == null) throw new UsernameNotFoundException("USER 404");
		else
		return new UserPrincipal(user);
	}

}
