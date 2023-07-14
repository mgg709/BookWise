package com.example.backend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
public class Book {
    
    @Id
    Integer id;
    @Field(type = FieldType.Text, name = "title")
    String title;
    @Field(type = FieldType.Text, name = "category")
    String category;
    @Field(type = FieldType.Double, name = "price")
    Double price;
    @Field(type = FieldType.Integer, name = "numberOfReviews")
    Integer numberOfReviews;
    @Field(type = FieldType.Text, name = "description")
    String description;
    @Field(type = FieldType.Text, name = "imageLink")
    String imageLink;
    @Field(type = FieldType.Integer_Range, name = "stars")
    Range<Integer> stars = Range.closed(0,5);
    @Field(type = FieldType.Integer, name = " numberOfPages")
    Integer numberOfPages;
    @Field(type = FieldType.Text, name = "language")
    String language;
    @Field(type = FieldType.Text, name = "binding")
    String binding;
    @Field(type = FieldType.Integer, name = "weight")
    Integer weight;
    @Field(type = FieldType.Integer, name = "yearOfEdition")
    Integer yearOfEdition;
    @Field(type = FieldType.Nested, name = "adjectives")
    List<String> adjectives;
    
}
