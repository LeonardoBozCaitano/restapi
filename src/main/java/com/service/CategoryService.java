package com.service;
import com.entity.Category;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository _categoryRepository){
        this.categoryRepository = _categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(String id){
        return categoryRepository.findById(id).get();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(String id, Category categoryRequest){
        Category category = categoryRepository.findById(id).get();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(String Id){
        Category category = this.getCategory(Id);
        categoryRepository.delete(category);
    }

}