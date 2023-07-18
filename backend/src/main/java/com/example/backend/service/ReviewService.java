package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.backend.model.Review;

import com.example.backend.repositories.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService{
    
    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByTitleBook(String titleBook){
        return reviewRepository.findByTitleBook(titleBook);
    }

    public List<Review> getReviewsByUsername(String username){
        return reviewRepository.findByUsername(username);
    }

}
