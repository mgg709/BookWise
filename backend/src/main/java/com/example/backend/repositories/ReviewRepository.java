package com.example.backend.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.backend.model.Review;

public interface ReviewRepository extends MongoRepository<Review,String>{
    
    @Query("{username:'?0'}")
    public List<Review> findByUsername(String username);

    @Query("{titlebook:'?0'}")
    public List<Review> findByTitleBook(String titleBook);

}
