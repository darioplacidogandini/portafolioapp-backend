package com.dariogandini.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {
    @RequestMapping({"/api"})
    public String apiPage() {
        return "Api";
    }
}   