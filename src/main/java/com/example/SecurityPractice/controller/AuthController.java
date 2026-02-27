package com.example.SecurityPractice.controller;

import com.example.SecurityPractice.dao.LoginRequestDao;
import com.example.SecurityPractice.dao.UserRequestDao;
import com.example.SecurityPractice.service.AuthService;
import com.example.SecurityPractice.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final AuthService authService;

    public AuthController(UsersService usersService,
                          AuthService authService) {
        this.usersService = usersService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public Object register(@RequestBody UserRequestDao dto) {
        return usersService.save(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDao dto) {
        authService.login(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok("Login successful");
    }
}