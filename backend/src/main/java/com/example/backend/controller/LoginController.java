package com.example.backend.controller;

import com.example.backend.exceptions.LoginException;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<String> login(@RequestParam(name = "user") final String user,
                                @RequestParam(name = "password") final String password,
                                HttpSession session) throws LoginException {

        return this.userService.login(user, password, session);
    }

}