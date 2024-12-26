package com.roshan.twofa.service;

import com.roshan.twofa.dto.requestdto.UserLoginRequest;
import com.roshan.twofa.dto.responsedto.UserResponseDto;
import com.roshan.twofa.entity.Users;
import com.roshan.twofa.mapper.UserMapper;
import com.roshan.twofa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER"));
        return userRepo.save(user);
    }
    public UserResponseDto login(UserLoginRequest user) {
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()
                ));
        if(authentication.isAuthenticated()) {
            return UserMapper.userToUserDto(userRepo.findByUsername(user.getUsername()));
        }
        return null;
    }

}
