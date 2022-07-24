package com.example.demo4.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo4.model.Role;

@Repository
public interface RoleRepository  extends CrudRepository<Role, Integer> {
	 Role findByName(String name);
}
