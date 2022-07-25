package com.example.demo4.respository;

import com.example.demo4.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {
    Category findCategoriesById(int id);
    Category findCategoriesByName(String name);
}
