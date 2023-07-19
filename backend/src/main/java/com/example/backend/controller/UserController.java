package com.example.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.User;
import com.example.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/addFavourite")
    public void addFavourites(@RequestParam String username,@RequestParam String booktitle){
        userService.addFavourites(username, booktitle);
    }

    @DeleteMapping("/removeFavourite")
    public void removeFavourites(@RequestParam String username,@RequestParam String booktitle){
        userService.removeFavourites(username, booktitle);
    }

   
    
}
