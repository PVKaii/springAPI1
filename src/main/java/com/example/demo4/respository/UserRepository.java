package com.example.demo4.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo4.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
