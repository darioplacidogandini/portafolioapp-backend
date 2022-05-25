package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Proyectos;
import com.dariogandini.portfolio.repository.ProyectosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController {

    @Autowired
    private ProyectosRepository proyectosRepository;

    @GetMapping("/listar")
    public List<Proyectos> listar() {
        return proyectosRepository.findAll();
    }

    @PostMapping("/agregar")
    public Proyectos agregar(@RequestBody Proyectos proyectos) {
        return proyectosRepository.save(proyectos);
    }
    
}
