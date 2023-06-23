package com.example.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Book;
import com.example.backend.service.IndexService;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    public IndexController(){}

    public IndexController(IndexService indexService){
        this.indexService = indexService;
    }

    @PostMapping
    public List<Book> indexBooks() throws IOException {
        return indexService.createAndGetBooks();
    }

}
