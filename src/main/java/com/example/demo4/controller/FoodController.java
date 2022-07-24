package com.example.demo4.controller;

import java.util.List;

import com.example.demo4.model.Food;
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

import com.example.demo4.service.impl.FoodServiceImpl;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodServiceImpl foodService;


	@GetMapping("")
	public List<Food> getAllUser(){
		return foodService.getAllFood();
	}


	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Food deleteUser(@PathVariable(name="id") int id) {
		Food foodDelete= foodService.findFoodById(id);
		foodService.deleteFood(id);
		return foodDelete;
	}


	@PostMapping("add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Food addUser(@RequestBody Food food) {
		foodService.saveFood(food);
		return food;
	}


	@PutMapping("edit/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Food editUser(@PathVariable(name="id") int id,@RequestBody Food food) {
		Food editFood=foodService.findFoodById(id);
		if(editFood==null) {
			return null;
		}
		else {
//			editUser.setEmail(user.getEmail());
//			editUser.setName(user.getName());
//			editUser.setPhone(user.getPhone());
//			userService.saveUser(editUser);
			return editFood;
		}
	}
	@GetMapping("/{id}")

	public Food findUserById(@PathVariable(name="id") int id) {
		return foodService.findFoodById(id);
	}
}
