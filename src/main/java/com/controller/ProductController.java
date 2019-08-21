package com.controller;

import com.entity.Product;
import com.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="API Rest - Products")
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/produtos")
    @ApiOperation(value="Return a product List")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation(value="Return a product")
    public Product getProduct(@PathVariable(value="id") String id){
        return productService.getProduct(id);
    }

    @PostMapping("/produtos")
    @ApiOperation(value="Add a product")
    public Product addProduct(@RequestBody Product category) {
        return productService.addProduct(category);
    }

    @PutMapping("/produtos/{id}")
    @ApiOperation(value="Update a product")
    public Product updateProduct(@PathVariable String id, @RequestBody Product category) {
        return productService.updateProduct(id, category);
    }

    @DeleteMapping("/produtos/{id}")
    @ApiOperation(value="Delete a product")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
