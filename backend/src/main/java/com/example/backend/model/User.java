package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection="User")
@Data
@AllArgsConstructor
public class User {
    
    @Id
    private String Id;

    private String email;
    private String username;
    private String password;
    private String[] favourites;
}
