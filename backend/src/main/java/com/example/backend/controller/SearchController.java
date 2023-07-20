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


    //This is just a placeholder while learning more Elastic
    @GetMapping("/advanced")
    public Book advancedSearch(
            @RequestParam(name = "tittle", defaultValue = "", required = false)
            final String tittle,
            @RequestParam(name = "category", defaultValue = "", required = false)
            final String category) {

        return this.bookService.findByTitle(tittle);
    }



}
