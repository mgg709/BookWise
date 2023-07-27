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
    public List<Book> findByTitle(@PathVariable final String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("/category/{title}")
    public List<Book> findByCategory(@PathVariable final String title){
        Book book = bookService.findByTitle(title).get(0);
        return bookService.findByCategory(book.getCategory());
    }

    //This is just a placeholder while learning more Elastic
    @GetMapping("/advanced")
    public List<Book> advancedSearch(
            @RequestParam(name = "tittle", defaultValue = "", required = false)
            final String tittle,
            @RequestParam(name = "category", defaultValue = "", required = false)
            final String category) {

        return this.bookService.findByTitle(tittle);
    }



}