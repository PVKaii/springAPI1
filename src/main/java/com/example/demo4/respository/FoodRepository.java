package com.example.demo4.respository;

import com.example.demo4.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food,Integer> {
	Food findFoodById(int id);
}
