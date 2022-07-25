package com.example.demo4.service;

import com.example.demo4.model.Food;

import java.util.List;

public interface FoodService {
	List<Food> getAllFood();

	void deleteFood(int id);

	Food saveFood(Food food);

	Food findFoodById(int id);
}
