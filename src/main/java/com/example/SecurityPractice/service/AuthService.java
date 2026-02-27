package com.example.SecurityPractice.service;

import com.example.SecurityPractice.config.JwtUtil;
import com.example.SecurityPractice.dao.AuthResponse;
import com.example.SecurityPractice.entity.Users;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsersService usersService;
    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsersService usersService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usersService = usersService;
    }

    public AuthResponse login(String email, String password) {
        Authentication authToken =
                new UsernamePasswordAuthenticationToken(email, password);

        authenticationManager.authenticate(authToken);
        Users user=usersService.findByEmail(email);
        String token =jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}