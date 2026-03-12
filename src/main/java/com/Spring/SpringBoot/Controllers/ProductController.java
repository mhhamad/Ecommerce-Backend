package com.Spring.SpringBoot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.Spring.SpringBoot.models.Product;
import com.Spring.SpringBoot.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
       
    ProductController(ProductService productService) {
        this.productService = productService;
    }   

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }
    

}
