package com.example.demo.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(){
        return "reg/login";
    }
    @GetMapping("/")
    public String home(){
        return "reg/home";
    }
}
