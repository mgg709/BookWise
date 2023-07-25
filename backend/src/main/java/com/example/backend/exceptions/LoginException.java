package com.example.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpSession;

@Getter
public class LoginException extends Exception{

    HttpStatus status;

    public LoginException(String message, HttpStatus status) {

        super(message);
        this.status = status;
    }

}
