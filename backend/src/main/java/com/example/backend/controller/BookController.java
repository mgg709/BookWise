package com.example.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Book;
import com.example.backend.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public void saveBooks() throws IOException {
        bookService.indexBooks();
    }

    @GetMapping("{title}")
    public List<Book> findByTitle(@PathVariable final String title){
        return bookService.findByTitle(title);
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/getTwentyBooks/{page}")
    public PageImpl<Book> getTwentyBooks(@PathVariable final int page){
        return bookService.getTwentyBooks(page);
    }


}
