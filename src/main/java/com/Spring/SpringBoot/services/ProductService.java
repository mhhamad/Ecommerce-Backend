package com.Spring.SpringBoot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring.SpringBoot.models.Product;
import com.Spring.SpringBoot.repository.ProductRepo;

@Service
public class ProductService {
    // call repository layer to get products from database
    private ProductRepo productRepo;

    ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(String id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }

    public Product updateProduct(String id, Product updatedProduct) {
        return productRepo.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return productRepo.save(product);
        }).orElse(null);
    }

    


}
