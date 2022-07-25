package com.example.demo4.service;

import com.example.demo4.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);

    void delete(int id);

    Category findCategoryById(int id);
}
