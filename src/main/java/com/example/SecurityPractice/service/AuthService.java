package com.example.SecurityPractice.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Authentication login(String email, String password) {
        Authentication authToken =
                new UsernamePasswordAuthenticationToken(email, password);

        return authenticationManager.authenticate(authToken);
    }
}