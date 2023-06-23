package com.example.backend.model;

import java.util.List;
import com.example.backend.repositories.BookRepository;


public class Book {
    
    private final BookRepository bookRepository;

    public Book(){
        this.bookRepository = null;
    }
    public Book(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    void findBook(){
        List<Book> books = bookRepository.findByTitle("Elasticsearch Basics");
    }
}
