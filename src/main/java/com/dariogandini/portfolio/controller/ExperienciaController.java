package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Experiencia;
import com.dariogandini.portfolio.repository.ExperienciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {
    
    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping("/listar")
    public List<Experiencia> listar() {
        return experienciaRepository.findAll();
    }

    @PostMapping("/agregar")
    public Experiencia agregar(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }}
