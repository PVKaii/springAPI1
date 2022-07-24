package com.example.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.model.UserInfor;
import com.example.demo4.service.impl.UserInforServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserInforServiceImpl userService;
	
	
	@GetMapping("")
	public List<UserInfor> getAllUser(){
		return userService.getAllUser();
	}
	@PostMapping("")
	public List<UserInfor> getAllUser(@RequestBody String fullName){
		System.out.print(fullName);
		return userService.getAllUser();
	}
	
	
	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserInfor deleteUser(@PathVariable(name="id") long id) {
		UserInfor userDelete= userService.findUserById(id);
		userService.deleteUser(id);
		return userDelete;
	}
	
	
	@PostMapping("add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserInfor addUser(@RequestBody UserInfor user) {
		userService.saveUser(user);
		return user;
	}
	
	
	@PutMapping("edit/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserInfor editUser(@PathVariable(name="id") long id,@RequestBody UserInfor user) {
		UserInfor editUser=userService.findUserById(id);
		if(editUser==null) {
			return null;
		}
		else {
			editUser.setEmail(user.getEmail());
			editUser.setName(user.getName());
			editUser.setPhone(user.getPhone());
			userService.saveUser(editUser);
			return editUser;
		}
	}
	@GetMapping("/{id}")

	public UserInfor findUserById(@PathVariable(name="id") long id) {
		return userService.findUserById(id);
	}
}
