package com.example.demo4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo4.model.Role;
import com.example.demo4.respository.RoleRepository;
import com.example.demo4.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}

	@Override
	public Iterable<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
