package com.controller;

import com.service.CategoryService;
import com.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(value="API Rest - Categories")
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categorias")
    @ApiOperation(value="Return a category List")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping("/categorias/{id}")
    @ApiOperation(value="Return a category")
    public Category getCategory(@PathVariable(value="id") String id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/categorias")
    @ApiOperation(value="Add a category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/categorias/{id}")
    @ApiOperation(value="Update a category")
    public Category updateCategory(@PathVariable String id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/categoria/{id}")
    @ApiOperation(value="Delete a category")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }
}
