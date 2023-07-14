package com.example.backend.controller;

import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    //TODO: Build this when User part is finished
    @PostMapping
    public void login(@RequestParam(name = "user") final String user,
                      @RequestParam(name = "password") final String password) {


    }


}
