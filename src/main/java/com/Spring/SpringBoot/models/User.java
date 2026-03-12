package com.Spring.SpringBoot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {
    @Email
    @NotBlank
    @Id
    private String email;

    @NotBlank
    private String name;
    
    @NotBlank
    private String password;

    
}
