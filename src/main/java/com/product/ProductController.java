package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/produtos")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("/produtos/{id}")
    public Product getProduct(@PathVariable(value="id") String id){
        return productService.getProduct(id);
    }

    @PostMapping("/produtos")
    public Product addProduct(@RequestBody Product category) {
        return productService.addProduct(category);
    }

    @PutMapping("/produtos/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product category) {
        return productService.updateProduct(id, category);
    }

    @DeleteMapping("/produtos/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
