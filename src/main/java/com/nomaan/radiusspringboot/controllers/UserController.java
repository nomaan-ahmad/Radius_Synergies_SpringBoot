package com.nomaan.radiusspringboot.controllers;

import com.nomaan.radiusspringboot.models.User;
import com.nomaan.radiusspringboot.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserData() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User aux = userRepository.save(user);
        return new ResponseEntity<>(aux, HttpStatus.CREATED);
    }

}
