package com.example.backend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection="User")
@Data
@AllArgsConstructor
public class User {
    
    @Id
    private String id;

    private String email;
    private String username;
    private String password;
    private List<String> favourites;

    public void addFavourites(String booktitle){
        this.favourites.add(booktitle);
    }

    public void removeFavourites(String booktitle){
        this.favourites.remove(booktitle);
    }
}
