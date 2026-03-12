package com.Spring.SpringBoot;

import com.Spring.SpringBoot.models.Product;
import com.Spring.SpringBoot.repository.ProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ProductRepo productRepo;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Product product1;
    private Product product2;

    @BeforeEach
    void setup() {
        // Build MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        // Clear DB and add test products
        productRepo.deleteAll();
        product1 = new Product("p1", "Product One", 10.0);
        product2 = new Product("p2", "Product Two", 20.0);
        productRepo.saveAll(Arrays.asList(product1, product2));
    }

    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("p1"))
                .andExpect(jsonPath("$[1].name").value("Product Two"));
    }

    @Test
    void testGetProductById() throws Exception {
        mockMvc.perform(get("/products/p1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Product One"));
    }

    @Test
    void testSaveProduct() throws Exception {
        Product newProduct = new Product("p3", "Product Three", 30.0);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("p3"))
                .andExpect(jsonPath("$.price").value(30.0));
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product updatedProduct = new Product("p1", "Updated Product", 15.0);

        mockMvc.perform(put("/products/p1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Product"))
                .andExpect(jsonPath("$.price").value(15.0));
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/products/p1"))
                .andExpect(status().isOk());

        // Confirm it’s deleted
        mockMvc.perform(get("/products/p1"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}