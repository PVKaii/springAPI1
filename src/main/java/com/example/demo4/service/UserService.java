package com.example.demo4.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo4.model.User;

public interface UserService extends UserDetailsService {
	void save(User user);
	
	Iterable<User> findAll();
	
	User FindUserByEmail(String email);
}
