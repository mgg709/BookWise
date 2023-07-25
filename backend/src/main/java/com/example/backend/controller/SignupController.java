package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<String> signUp(@RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password,
                                         @RequestParam(name = "mail") String email,
                                         HttpSession session) {

        if(userService.usernameExist(username))
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);

        if(userService.emailExist(email))
            return new ResponseEntity<>("Email already in use", HttpStatus.BAD_REQUEST);


        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setFavourites(new ArrayList<>());

        userService.save(user);

        session.setAttribute("login", true);

        return new ResponseEntity<String>(username, HttpStatus.OK);
    }



    @GetMapping("/user")
    public boolean usernameExist(@RequestParam(name = "username", required = true) String username) {
        return this.userService.usernameExist(username);
    }



    @GetMapping("/email")
    public boolean emailExist(@RequestParam(name = "email", required = true) String email) {
        return this.userService.emailExist(email);
    }

}
