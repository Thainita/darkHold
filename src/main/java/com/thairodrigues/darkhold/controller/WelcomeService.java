package com.thairodrigues.darkhold.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WelcomeService {

    @GetMapping("/welcome")
    public String getWelcomeMessage(){
        return "welcome to darkhold";
    }

}
