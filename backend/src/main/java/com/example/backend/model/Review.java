package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private Integer id;

    @Field(type = FieldType.Text, name = "review")
    private String review;

    @Field(type = FieldType.Integer_Range, name = "stars")
    private Range<Integer> stars = Range.closed(0,5);

    @Field(type = FieldType.Object, name = "books")
    private Book book;
}
