package com.example.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.backend.model.User;

public interface UserRepository extends MongoRepository<User,String>{
    @Query("{username:'?0'}")
    User findItemByUsername(String username);

    @Query("{email:'?0'}")
    User findItemByEmail(String username);



}
