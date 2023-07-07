package com.example.backend.controller;

import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Book;
import com.example.backend.service.BookService;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/books")

public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService){
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



    /**
     * Run indexing when dependency injection finish
     * @throws IOException
     */
    @PostConstruct
    public void indexStarting() {
        try {
            bookService.indexBooks();
        }
        catch (Exception ex) {
            System.out.println("Esto es un mensaje de error");
        }
    }


}
