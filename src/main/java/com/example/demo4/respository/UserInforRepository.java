package com.example.demo4.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo4.model.UserInfor;

@Repository
public interface UserInforRepository extends CrudRepository<UserInfor, Long> {

	UserInfor findUserById(Long id);
}
