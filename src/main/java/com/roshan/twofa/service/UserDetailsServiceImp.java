package com.roshan.twofa.service;

import com.roshan.twofa.entity.Users;
import com.roshan.twofa.helper.UserPrincipal;
import com.roshan.twofa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users =  userRepo.findByUsername(username);
        if(users==null){
            throw new UsernameNotFoundException(username + " not found");
        }
        return new UserPrincipal(users);
    }
}
