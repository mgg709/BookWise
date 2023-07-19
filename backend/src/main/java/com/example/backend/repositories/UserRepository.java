package com.example.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.backend.model.User;

public interface UserRepository extends MongoRepository<User,String>{
    
    User findByUsername(String username);

    
}
