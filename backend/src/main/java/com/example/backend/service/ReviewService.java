package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.backend.model.Review;

import com.example.backend.repositories.ReviewRepository;

import co.elastic.clients.elasticsearch.nodes.Http;
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

    public ResponseEntity<Review> addReview(Review review){
        try{
            reviewRepository.save(review);
            return new ResponseEntity<Review>(review, HttpStatus.CREATED); 
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
          
    }

}
