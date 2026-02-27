package com.example.SecurityPractice.controller;

import com.example.SecurityPractice.dao.UserRequestDao;
import com.example.SecurityPractice.entity.Users;
import com.example.SecurityPractice.service.UsersService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UsersService service;

    public UserController(UsersService service) {
        this.service = service;
    }

    @PostMapping
    public Users save(@RequestBody UserRequestDao userRequestDao) {
        return service.save(userRequestDao);
    }

    @GetMapping("/{email}")
    public Users findAll(@PathVariable String email) {
        return service.findByEmail(email);
    }
}