package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "books")
public class Book {
    
    @Id
    private Integer id;

    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Field(type = FieldType.Text, name = "category")
    private String category;

    @Field(type = FieldType.Double, name = "price")
    private Double price;

    @Field(type = FieldType.Integer, name = "numberOfReviews")
    private Integer numberOfReviews;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Text, name = "imageLink")
    private String imageLink;

    @Field(type = FieldType.Integer_Range, name = "stars")
    private Range<Integer> stars = Range.closed(0,5);

    @Field(type = FieldType.Integer, name = " numberOfPages")
    private Integer numberOfPages;

    @Field(type = FieldType.Text, name = "language")
    private String language;

    @Field(type = FieldType.Text, name = "binding")
    private String binding;

    @Field(type = FieldType.Integer, name = "weight")
    private Integer weight;

    @Field(type = FieldType.Integer, name = "yearOfEdition")
    private Integer yearOfEdition;
}
