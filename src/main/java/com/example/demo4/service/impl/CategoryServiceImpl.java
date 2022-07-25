package com.example.demo4.service.impl;

import com.example.demo4.model.Category;
import com.example.demo4.respository.CategoryRepository;
import com.example.demo4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category save(Category category)  {
       return categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findCategoriesById(id);
    }
}
