package com.Spring.SpringBoot.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor    // generates default constructor
@AllArgsConstructor   // generates constructor with all fields
@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private double price;

}
