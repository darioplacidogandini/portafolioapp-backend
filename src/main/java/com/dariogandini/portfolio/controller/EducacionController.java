package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Educacion;
import com.dariogandini.portfolio.repository.EducacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/educacion")
public class EducacionController {

    @Autowired
    private EducacionRepository educacionRepository;

    @GetMapping("/listar")
    public List<Educacion> listar() {
        return educacionRepository.findAll();
    }

    @PostMapping("/agregar")
    public Educacion agregar(@RequestBody Educacion educacion) {
        return educacionRepository.save(educacion);
    }
    
}
