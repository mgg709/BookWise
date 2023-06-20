package com.example.indexer;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "book")
public class Book {
    @Id
    private String id;
    @Field(type = FieldType.Text, name = "title")
    private String title;
    @Field(type = FieldType.Text, name = "category")
    private String category;
    @Field(type = FieldType.Double, name = "price")
    private double price;
    @Field(type = FieldType.Integer, name = "numberOfReviews")
    private int numberOfReviews;
    @Field(type = FieldType.Text, name = "description")
    private String description;
    @Field(type = FieldType.Text, name = "imageLink")
    private String imageLink;
    @Field(type = FieldType.Integer, name = "stars")
    private int stars;
    @Field(type = FieldType.Integer, name = " numberOfPages")
    private int numberOfPages;
    @Field(type = FieldType.Text, name = "language")
    private String language;
    @Field(type = FieldType.Text, name = "binding")
    private String binding;
    @Field(type = FieldType.Integer, name = "weight")
    private int weight;
    @Field(type = FieldType.Integer, name = "yearOfEdition")
    private int yearOfEdition;

    public Book(){}

    public Book(String id, String title, String category, double price, int numberOfReviews, String description, String imageLink, int stars, int numberOfPages, String language, String binding, int weight, int yearOfEdition) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getYearOfEdition() {
        return yearOfEdition;
    }

    public void setYearOfEdition(int yearOfEdition) {
        this.yearOfEdition = yearOfEdition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
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
