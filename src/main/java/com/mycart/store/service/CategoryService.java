package com.mycart.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycart.store.model.Category;
import com.mycart.store.repository.CategoryRepository;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    public void createCategory(Category category){
        if (category.getName()!=null && category.getDescription()!=null) 
            categoryRepository.save(category);
        else
            throw new IllegalArgumentException("Unable to create category");
    }
    public Category findCategory(Long categId){
        return categoryRepository.findById(categId)
        .orElseThrow(()->new IllegalArgumentException("Unable to find category"));
    }
    public void updateCategory(Category updatedCategory){    
        if (updatedCategory.getName()!=null && updatedCategory.getDescription()!=null) {
            categoryRepository.findById(updatedCategory.getCateg_id())
            .map(category->{
                category.setName(updatedCategory.getName());
                category.setDescription(updatedCategory.getDescription());
                return categoryRepository.save(category);
            })
            .orElseThrow(()->new IllegalArgumentException("Unable to update category"));
        }
        else
            throw new IllegalArgumentException("Unable to update category");
    }
    public void deleteCategory(Long id){
        if (findCategory(id)!=null)
            categoryRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Unable to delete category");
    }
}
