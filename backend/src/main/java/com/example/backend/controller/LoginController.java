package com.example.backend.controller;

import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
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
                                HttpSession session) {

        ResponseEntity<String> response;

        switch (this.userService.login(user, password)) {

            case 0:
                //200
                session.setAttribute("login", true);
                response = new ResponseEntity<String>(user, HttpStatus.OK);
                break;


            case 1:
                //400
                response = new ResponseEntity<>("Wrong username", HttpStatus.BAD_REQUEST);
            break;


            case 2:
                //401
                response = new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
            break;


            default:
                //Anything else
                response = new ResponseEntity<>("Some error happend", HttpStatus.NOT_FOUND);
            break;
        }

        return response;
    }


}
