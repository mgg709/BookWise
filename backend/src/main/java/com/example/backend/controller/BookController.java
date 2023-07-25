package com.example.backend.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Book;
import com.example.backend.service.BookService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;



    @GetMapping
    public List<Book> findAll(){

        return bookService.findAll();
    }


    @GetMapping("/twentyBooks/{page}")
    public PageImpl<Book> getTwentyBooks(@PathVariable final int page) {

        return bookService.getTwentyBooks(page);
    }


    @GetMapping("best-rated")
    public ResponseEntity<List<Book>> getTenBestRated() {

        return bookService.get10BestRated();
    }


    @GetMapping("best-sellers")
    public ResponseEntity<List<Book>> getTenBestSellings(){

        return bookService.get10BestSellings();
    }
}