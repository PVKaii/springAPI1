package com.example.demo4.service;

import com.example.demo4.model.Role;

public interface RoleService  {
	Role findRoleByName(String name);
	
	Iterable<Role> findAll();
}
