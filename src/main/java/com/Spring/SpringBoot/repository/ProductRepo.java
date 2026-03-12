package com.Spring.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.SpringBoot.models.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
    
}
