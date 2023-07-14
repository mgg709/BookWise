package com.example.backend.controller;

import com.example.backend.model.Book;
import com.example.backend.service.BookService;
import com.example.backend.service.RecommendationService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping
    public ResponseEntity<List<Book>> recommendBooks(@RequestParam String title, @RequestParam String[] categories, @RequestParam Integer days){
        return new ResponseEntity<List<Book>>(recommendationService.getRecommendations(title, categories, days), HttpStatus.OK);
    }



}
