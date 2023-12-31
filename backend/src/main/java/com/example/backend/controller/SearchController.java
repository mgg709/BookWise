package com.example.backend.controller;

import com.example.backend.model.Book;
import com.example.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final BookService bookService;


    @GetMapping("{word}")
    public List<Book> searchByString(@PathVariable final String word) {

        return this.bookService.findByString(word);
    }

    @GetMapping("/title/{title}")
    public Book findByTitle(@PathVariable final String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("/category/{title}")
    public List<Book> findByCategory(@PathVariable final String title){
        Book book = bookService.findByTitle(title);
        return bookService.findByCategory(book.getCategory());
    }

}