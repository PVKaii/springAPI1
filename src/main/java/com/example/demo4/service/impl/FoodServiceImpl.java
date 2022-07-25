package com.example.demo4.service.impl;

import java.util.List;

import com.example.demo4.model.Food;
import com.example.demo4.respository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo4.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodRepository foodRepository;


	@Override
	public List<Food> getAllFood() {
		return (List<Food>) foodRepository.findAll();
	}

	@Override
	public void deleteFood(int id) {
		foodRepository.deleteById(id);
	}

	@Override
	public Food saveFood(Food food) {
		return foodRepository.save(food);

	}

	@Override
	public Food findFoodById(int id) {
		return foodRepository.findFoodById(id);
	}
}
