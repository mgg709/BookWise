package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.model.User;
import com.example.backend.repositories.UserRespository;

@Service
public class UserService{

    private final UserRespository userRepository;

    public UserService(UserRespository userRespository){
        this.userRepository=userRespository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
}
