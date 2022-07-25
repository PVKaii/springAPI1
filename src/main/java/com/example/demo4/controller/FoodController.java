package com.example.demo4.controller;

import java.util.List;

import com.example.demo4.model.Category;
import com.example.demo4.model.Food;
import com.example.demo4.model.pojo.FoodPrinciple;
import com.example.demo4.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	CategoryServiceImpl categoryService;

	@GetMapping("")
	public ResponseEntity<?> getAllFood(){
		try{
			return new ResponseEntity<List<Food>>(foodService.getAllFood(), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteFood(@PathVariable(name="id") int id) {
		try{
			Food foodDelete= foodService.findFoodById(id);
			if(foodDelete!=null){
				foodService.deleteFood(id);
				return new ResponseEntity<FoodPrinciple>(new FoodPrinciple(foodDelete), HttpStatus.OK);
			}
			throw new Exception();
		}catch (Exception e){
			return new ResponseEntity<String>("Food not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addFood(@RequestBody FoodPrinciple foodPrinciple) {
		try{
			Category category=  categoryService.findCategoryById(foodPrinciple.getCategory());
			Food food=new Food(foodPrinciple,category);
			foodService.saveFood(food);
			return new ResponseEntity<FoodPrinciple>(new FoodPrinciple(food), HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Food existed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PutMapping("edit/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> editFood(@PathVariable(name="id") int id,@RequestBody FoodPrinciple foodPrinciple) {
		try{
			Food editFood=foodService.findFoodById(id);
			if(editFood!=null){
				editFood.setName(foodPrinciple.getName());
				editFood.setQuantity(foodPrinciple.getQuantity());
				editFood.setAvailable(foodPrinciple.isAvailable());
				editFood.setCategory(categoryService.findCategoryById(foodPrinciple.getCategory()));
				foodService.saveFood(editFood);
				return new ResponseEntity<FoodPrinciple>(new FoodPrinciple(editFood), HttpStatus.OK);
			}
			throw new Exception();
		}catch (Exception e){
			return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findFoodById(@PathVariable(name="id") int id) {
		try{
			Food food= foodService.findFoodById(id);
			if(food!=null){
				return new ResponseEntity<FoodPrinciple>(new FoodPrinciple(food), HttpStatus.OK);
			}
			throw new Exception();
		}catch (Exception e){
			return new ResponseEntity<String>("Food not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
