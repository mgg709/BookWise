package com.example.backend.model;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Document(collection="User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    private String Id;

    private String email;
    private String username;
    private String password;

    private List<String> favourites;

    @DBRef
    private List<Review> reviews;
}
