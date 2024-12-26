package com.roshan.twofa.controller;

import com.roshan.twofa.dto.requestdto.UserLoginRequest;
import com.roshan.twofa.dto.responsedto.UserResponseDto;
import com.roshan.twofa.entity.Users;
import com.roshan.twofa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    private final UserService userService;
    public PublicController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user){
        Users users = userService.saveUser(user);
        if(users != null){
            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.badRequest().body("User registration failed");

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest user){
        UserResponseDto users = userService.login(user);
        if(users != null){
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }
}
