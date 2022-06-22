package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Acerca;
import com.dariogandini.portfolio.repository.AcercaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Acerca> buscar(@PathVariable Long id) {
        Acerca acerca = acercaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(acerca);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Acerca> editar(@PathVariable Long id, @RequestBody Acerca detallesAcerca) {
        Acerca acerca = acercaRepository.findById(id).orElse(null);
        acerca.setNombre(detallesAcerca.getNombre());
        acerca.setPuesto(detallesAcerca.getPuesto());
        acerca.setFoto(detallesAcerca.getFoto());
        acerca.setPortada(detallesAcerca.getPortada());
        Acerca acercaModificado = acercaRepository.save(acerca);
        return ResponseEntity.ok(acercaModificado);
    }

}

