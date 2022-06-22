package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Acerca;
import com.dariogandini.portfolio.repository.AcercaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"https://dariogandini-portfoliofrontend.firebaseapp.com","https://dariogandini-portfoliofrontend.web.app"})
@RestController
@RequestMapping("/api/acerca")
public class AcercaController {

    @Autowired
    private AcercaRepository acercaRepository;

    @GetMapping("/listar")
    public List<Acerca> listar() {
        return acercaRepository.findAll();
    }

    @PutMapping("/editar")
    public ResponseEntity<Acerca> editar() {
        Acerca acerca = acercaRepository.findById((long) 1).orElse(null);
        acerca.setNombre(acerca.getNombre());
        acerca.setPuesto(acerca.getPuesto());
        acerca.setFoto(acerca.getFoto());
        acerca.setPortada(acerca.getPortada());
        Acerca acercaModificado = acercaRepository.save(acerca);
        return ResponseEntity.ok(acercaModificado);
    }

}

