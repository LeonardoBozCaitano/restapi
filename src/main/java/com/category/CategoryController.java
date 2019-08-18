package com.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categoria")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping("/categoria/{id}")
    public Category getCategory(@PathVariable(value="id") String id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/categoria")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/categoria/{id}")
    public Category updateCategory(@PathVariable String id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }
}
