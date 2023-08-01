package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        Review newReview = new Review(review.getTitle(), review.getDescription(), review.getAssessment(), review.getTitlebook(), review.getUsername());
        return reviewService.addReview(newReview);
    }


    @DeleteMapping
    public ResponseEntity<Review> removeReview(@RequestParam String username,
                                               @RequestParam String bookTitle,
                                               @RequestParam String reviewTitle){
        return reviewService.removeReview(username, bookTitle, reviewTitle);
    }
}
