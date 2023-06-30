package com.example.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;


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

    public Book(Integer id, String title, String category, Double price, Integer numberOfReviews, String description, String imageLink, Range<Integer> stars, Integer numberOfPages, String language, String binding, Integer weight, Integer yearOfEdition) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.numberOfReviews = numberOfReviews;
        this.description = description;
        this.imageLink = imageLink;
        this.stars = stars;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.binding = binding;
        this.weight = weight;
        this.yearOfEdition = yearOfEdition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Range<Integer> getStars() {
        return stars;
    }

    public void setStars(Range<Integer> stars) {
        this.stars = stars;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getYearOfEdition() {
        return yearOfEdition;
    }

    public void setYearOfEdition(Integer yearOfEdition) {
        this.yearOfEdition = yearOfEdition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", numberOfReviews=" + numberOfReviews +
                ", description='" + description + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", stars=" + stars +
                ", numberOfPages=" + numberOfPages +
                ", language='" + language + '\'' +
                ", binding='" + binding + '\'' +
                ", weight=" + weight +
                ", yearOfEdition=" + yearOfEdition +
                '}';
    }
}
