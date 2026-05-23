package com.example.demoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Welcome to POC19 CI/CD Branching Strategy Demo";
    }

    @GetMapping("/login")
    public String login(){
        return "This is a Login Page";
    }
    @GetMapping("/signup")
    public String signup(){
        return "This is a Sign-Up Page";
    }
}
