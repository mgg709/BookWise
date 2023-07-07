package com.example.backend.controller;

import com.example.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    @Autowired
    private final BookService bookService;
}
