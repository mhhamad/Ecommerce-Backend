package com.Spring.SpringBoot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.Spring.SpringBoot.models.User;
import com.Spring.SpringBoot.repository.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepo userRepo;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private User user1;
    private User user2;

    @BeforeEach
    void setup() {
        // Build MockMvc with full context
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // Clean DB before each test
        userRepo.deleteAll();

        // Prepare users
        user1 = new User("user1@example.com", "User One", passwordEncoder.encode("password1"));
        user2 = new User("user2@example.com", "User Two", passwordEncoder.encode("password2"));
        userRepo.saveAll(Arrays.asList(user1, user2));
    }

    @Test
    void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("user1@example.com"))
                .andExpect(jsonPath("$[1].name").value("User Two"));
    }

    @Test
    void testGetUserByEmail() throws Exception {
        mockMvc.perform(get("/users/user1@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("User One"));
    }

    @Test
    void testSaveUser() throws Exception {
        User newUser = new User("newuser@example.com", "New User", "pass123");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("newuser@example.com"));
    }

    @Test
    void testUpdateUser() throws Exception {
        User updatedUser = new User("user1@example.com", "Updated Name", "newpassword");

        mockMvc.perform(put("/users/user1@example.com")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/users/user1@example.com"))
                .andExpect(status().isOk());
    }

    @Test
    void testCheckLogin() throws Exception {
        // Login with correct password
        mockMvc.perform(get("/users/login")
                        .param("email", "user2@example.com")
                        .param("password", "password2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

        // Login with wrong password
        mockMvc.perform(get("/users/login")
                        .param("email", "user1@example.com")
                        .param("password", "wrong"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}