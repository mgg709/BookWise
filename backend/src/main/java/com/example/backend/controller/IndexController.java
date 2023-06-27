package com.example.backend.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.IndexService;

@RestController
@RequestMapping("/api")
public class IndexController {
    
    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService){
        this.indexService = indexService;
    }

    @GetMapping("/index")
    public String indexingBooks() throws IOException{
        return indexService.indexingBooks();
    }
}
