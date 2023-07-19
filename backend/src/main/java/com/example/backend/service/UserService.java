package com.example.backend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.model.User;
import com.example.backend.repositories.UserRepository;

@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRespository){
        this.userRepository=userRespository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    public void addFavourites(String username, String booktitle){
        User user = userRepository.findByUsername(username);
        List<String> favourites = user.getFavourites();
        for (String title: favourites){
            if(title.equals(booktitle)){
                return;
            }
        }
        user.addFavourites(booktitle);
        userRepository.save(user);
    }

    public void removeFavourites(String username, String booktitle){
        User user = userRepository.findByUsername(username);
        try{
            user.removeFavourites(booktitle);
            userRepository.save(user);
        }catch (Exception e) {
            return;
        }
    }


}
