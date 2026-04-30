package com.gpcf.expenses_tracker.controller;

import com.gpcf.expenses_tracker.entity.LoginDto;
import com.gpcf.expenses_tracker.entity.User;
import com.gpcf.expenses_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> register( @RequestBody User user) {
        User savedUser = service.saveUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        User user = service.loginUser(dto.getUsername(), dto.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}