package com.example.demo4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo4.model.User;
import com.example.demo4.model.pojo.UserPrinciple;
import com.example.demo4.respository.UserRepository;
import com.example.demo4.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(username);
		if(user==null) {
			throw new  UsernameNotFoundException(username);
		}
		return UserPrinciple.build(user);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User FindUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

}
