package com.service;
import com.entity.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository _productRepository){
        this.productRepository = _productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(String id){
        return productRepository.findById(id).get();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product productRequest){
        Product product = productRepository.findById(id).get();
        product.setName(productRequest.getName());
        return productRepository.save(product);
    }

    public void deleteProduct(String id){
        Product product = this.getProduct(id);
        productRepository.delete(product);
    }

}
