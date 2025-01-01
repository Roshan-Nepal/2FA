package com.roshan.twofa.controller;

import com.roshan.twofa.dto.requestdto.UserLoginRequest;
import com.roshan.twofa.dto.responsedto.UserResponseDto;
import com.roshan.twofa.entity.Users;
import com.roshan.twofa.service.OtpService;
import com.roshan.twofa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    private final UserService userService;
    private final OtpService otpService;
    public PublicController(UserService userService, OtpService otpService) {
        this.userService = userService;
        this.otpService = otpService;
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

    @GetMapping("/get-otp")
    public ResponseEntity<?> getOTP(){
        return ResponseEntity.ok(otpService.getOtp());
    }
}
