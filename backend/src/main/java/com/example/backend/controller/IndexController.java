package com.example.backend.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public String indexBooks() throws IOException {
        return indexService.indexingBooks();
    }

}
