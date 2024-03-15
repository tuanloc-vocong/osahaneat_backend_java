package com.tuanloc.osahaneat.controller;

import com.tuanloc.osahaneat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userServiceImpl.getAllUser(), HttpStatus.OK);
    }
}
