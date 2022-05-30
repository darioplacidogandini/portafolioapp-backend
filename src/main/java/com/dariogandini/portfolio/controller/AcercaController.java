package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Acerca;
import com.dariogandini.portfolio.repository.AcercaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://dariogandini-portfoliofrontend.firebaseapp.com")
@RestController
@RequestMapping("/api/acerca")
public class AcercaController {

    @Autowired
    private AcercaRepository acercaRepository;

    @GetMapping("/listar")
    public List<Acerca> listar() {
        return acercaRepository.findAll();
    }

    @PostMapping("/editar")
    public Acerca editar(@RequestBody Acerca acerca) {
        return acercaRepository.save(acerca);
    }

}

