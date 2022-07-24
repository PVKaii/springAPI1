package com.example.demo4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo4.model.UserInfor;
import com.example.demo4.respository.UserInforRepository;
import com.example.demo4.service.UserInforService;


@Service
public class UserInforServiceImpl implements UserInforService {
	
	@Autowired
	UserInforRepository userRepository;
	
	
	@Override
	public List<UserInfor> getAllUser() {
		// TODO Auto-generated method stub
		return (List<UserInfor>) userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public void saveUser(UserInfor user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public UserInfor findUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findUserById(id);
	}

	
}
