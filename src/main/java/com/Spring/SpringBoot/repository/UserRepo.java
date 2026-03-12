package com.Spring.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.SpringBoot.models.User;

public interface UserRepo extends JpaRepository<User, String> {
    
}
