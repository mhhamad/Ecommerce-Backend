package com.Spring.SpringBoot.services;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Spring.SpringBoot.models.User;
import com.Spring.SpringBoot.repository.UserRepo;

@Service
public class UserService {
    private UserRepo userRepo;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserByemail(String email) {

        return userRepo.findById(email).orElse(null);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public void deleteUser(String email) {

        userRepo.deleteById(email);
    }

    public User updateUser(String email, User updatedUser) {

        return userRepo.findById(email).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

            return userRepo.save(user);
        }).orElse(null);
    }

    public int checkLogin(String email, String password) {
        User user = userRepo.findById(email).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return 1; // Login successful
        }
        return 0; // Login failed
    }

}
