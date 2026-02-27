package com.example.SecurityPractice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String home() {
        return "Welcome to the home page!";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/about")
    public String about() {
        return "This is the about page.";
    }
    @PostMapping("/add")
    public String add() {
        return "This is the add page.";
    }
}
