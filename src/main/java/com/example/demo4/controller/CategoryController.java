package com.example.demo4.controller;


import com.example.demo4.model.Category;
import com.example.demo4.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Category>> getAllCategory(){
        return new  ResponseEntity<List<Category>>(categoryService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        try {
            categoryService.save(category);
            return new ResponseEntity<Category>(category,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Category existed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") int id){
        try {
            Category category= categoryService.findCategoryById(id);
            if(category!=null){
                categoryService.delete(id);
                return new ResponseEntity<Category>(category,HttpStatus.OK);
            }
            else throw new Exception();
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not Found Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editCategory(@PathVariable(name = "id") int id , @RequestBody Category category){
        try {
            Category categoryEdit= categoryService.findCategoryById(id);
            if(categoryEdit!=null){
                categoryEdit.setName(category.getName());
                return new ResponseEntity<Category>(category,HttpStatus.OK);
            }
            else throw new Exception();
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not Found Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findCategoryById(@PathVariable(name = "id")int id){
        try {
            Category category= categoryService.findCategoryById(id);
            if(category!=null){
                return new ResponseEntity<Category>(category,HttpStatus.OK);
            }
            else throw new Exception();
        }
        catch (Exception e){
            return new ResponseEntity<String>("Not Found Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
