package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    Integer id;

    //TODO: Make this unique
    @Field(type = FieldType.Text, name = "username")
    String username;

    //This is wrong in so many levels...
    //TODO: If possible, make this secure
    @Field(type = FieldType.Text, name = "password")
    String password;

    Book favourites;
}
