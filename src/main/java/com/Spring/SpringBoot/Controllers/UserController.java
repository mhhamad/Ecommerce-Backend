package com.Spring.SpringBoot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.Spring.SpringBoot.models.User;
import com.Spring.SpringBoot.services.UserService;

@RestController
public class UserController {
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/users/{email}")
    public User getUserByemail(@PathVariable String email) {
        return userService.getUserByemail(email);
    }
    
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @DeleteMapping("/users/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }
    @PutMapping("/users/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        return userService.updateUser(email, updatedUser);
    }

    @GetMapping("/users/login")
    public int checkLogin(@RequestParam String email, @RequestParam String password) {
        return userService.checkLogin(email, password);
    }
}
