package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Review")
public class Review {

    @Id
    private String id;

    @DBRef
    private User author;

    private String title;
    private String description;
    private Integer assessment;
    private String titlebook;
    private String username;

    public Review(String title, String description, Integer assessment, String titlebook, String username) {
        this.title = title;
        this.description = description;
        this.assessment = assessment;
        this.titlebook = titlebook;
        this.username = username;
    }
}
