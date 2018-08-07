package com.quickjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/resource")
    public String getResource(){
        return "This is the resource that is only for users that are log in! You are Log in so don't worry!";
    }
}