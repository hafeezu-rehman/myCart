package com.mycart.store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.store.model.Category;
import com.mycart.store.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @PostMapping("/add")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        try {
            categoryService.createCategory(category);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
           return ResponseEntity.unprocessableEntity().build();
        }
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<Category> viewCategory(@PathVariable Long id){
        try {
            Category category=categoryService.findCategory(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        try {
            categoryService.updateCategory(category);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
           return ResponseEntity.unprocessableEntity().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
