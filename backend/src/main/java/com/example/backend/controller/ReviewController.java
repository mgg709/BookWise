package com.example.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Review;
import com.example.backend.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("book/{titleBook}")
    public ResponseEntity<List<Review>> getReviewsByTitleBook(@PathVariable final String titleBook){
        return ResponseEntity.ok(reviewService.getReviewsByTitleBook(titleBook));
    }

    @GetMapping("user/{username}")
    public ResponseEntity<List<Review>> getReviewsByUsername(@PathVariable final String username){
        return ResponseEntity.ok(reviewService.getReviewsByUsername(username));
    }
}
