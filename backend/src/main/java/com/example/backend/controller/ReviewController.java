package com.example.backend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Review;
import com.example.backend.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

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

    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        Review newReview = new Review(review.getUsername(), review.getTitlebook(), review.getAssessment(), review.getDescription(), review.getTitle());
        return reviewService.addReview(newReview);
    }

    @DeleteMapping("/removeReview")
    public ResponseEntity<Review> removeReview(@RequestParam String username, @RequestParam String bookTittle, @RequestParam String reviewTittle){
        return reviewService.removeReview(username, bookTittle, reviewTittle);
    }
}
