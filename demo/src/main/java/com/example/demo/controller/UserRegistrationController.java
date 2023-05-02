package com.example.demo.controller;

import com.example.demo.domen.User;
import com.example.demo.dto.RegistrationUser;
import com.example.demo.servis.UserServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private final UserServis userServis;


    public UserRegistrationController(UserServis userServis) {
        this.userServis = userServis;
    }
    @ModelAttribute("user")
    public RegistrationUser registrationUser(){
        return new RegistrationUser();
    }
    @GetMapping
    public String  showRegistrationForm(){
        return "reg/registration";

    }
    @PostMapping
    public String registrationAccaunt(@ModelAttribute("user") RegistrationUser registrationUser){
        userServis.save(registrationUser);
        return "redirect:registration?success";

    }
}
