package com.dariogandini.portafolioapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class portafolioappController {

    @GetMapping ("/portfolio")
    public String mostrarPortfolio() {
        return("index");    
    }
}
