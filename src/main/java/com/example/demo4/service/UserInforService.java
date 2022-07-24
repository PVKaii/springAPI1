package com.example.demo4.service;

import java.util.List;

import com.example.demo4.model.UserInfor;

public interface UserInforService {
	List<UserInfor> getAllUser();
	
	void deleteUser(long id);
	
	void saveUser(UserInfor user);
	
	UserInfor findUserById(long id);
}
