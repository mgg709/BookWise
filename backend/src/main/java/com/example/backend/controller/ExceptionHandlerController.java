package com.example.backend.controller;

import com.example.backend.exceptions.LoginException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = LoginException.class)
    public ResponseEntity<Map<String, String>> usernameError(LoginException ex) {

        Map<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());

        return new ResponseEntity<>(map, ex.getStatus());
    }
}
