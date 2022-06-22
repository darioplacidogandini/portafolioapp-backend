package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Experiencia;
import com.dariogandini.portfolio.repository.ExperienciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/experiencia")
public class ExperienciaController {
    
    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping("/listar")
    public List<Experiencia> listar() {
        return experienciaRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> buscar(@PathVariable Long id) {
        Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(experiencia);
    }

    @PostMapping("/agregar")
    public Experiencia agregar(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Experiencia> editar(@PathVariable(value = "id") Long experienciaId) {
        Experiencia experiencia = experienciaRepository.findById(experienciaId).orElse(null);
        experiencia.setEmpresa(experiencia.getEmpresa());
        experiencia.setPuesto(experiencia.getPuesto());
        experiencia.setInicio(experiencia.getInicio());
        experiencia.setFin(experiencia.getFin());
        experiencia.setLogo(experiencia.getLogo());
        Experiencia experienciaModificada = experienciaRepository.save(experiencia);
        return ResponseEntity.ok(experienciaModificada);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(value = "id") Long experienciaId) {
        Experiencia experiencia = experienciaRepository.findById(experienciaId).orElse(null);
        experienciaRepository.delete(experiencia);
    }

}
