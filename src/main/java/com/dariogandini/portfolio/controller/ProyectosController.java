package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Proyectos;
import com.dariogandini.portfolio.repository.ProyectosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"https://dariogandini-portfoliofrontend.firebaseapp.com","https://dariogandini-portfoliofrontend.web.app"})
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

    @PutMapping("/editar/{id}")
    public Proyectos editar(@PathVariable(value = "id") Long proyectosId) {
        Proyectos proyectos = proyectosRepository.findById(proyectosId).orElse(null);
        proyectos.setNombre(proyectos.getNombre());
        proyectos.setDescripcion(proyectos.getDescripcion());
        proyectos.setLogo(proyectos.getDescripcion());
        proyectos.setUrl(proyectos.getUrl());
        return proyectosRepository.save(proyectos);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(value = "id") Long proyectosId) {
        Proyectos proyectos = proyectosRepository.findById(proyectosId).orElse(null);
        proyectosRepository.delete(proyectos);
    }
    
}
