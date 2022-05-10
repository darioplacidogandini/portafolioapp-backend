package com.dariogandini.portafolioapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dariogandini.portafolioapp.model.Educacion;
import com.dariogandini.portafolioapp.model.EducacionRequest;
import com.dariogandini.portafolioapp.service.EducacionService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/educacion")
public class EducacionController {

    private final EducacionService educacionService;

    @Autowired
    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Educacion> ed(@PathVariable String id) {
        Optional<Educacion> ed = educacionService.findById(id);
        return ed.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
    }

    @GetMapping
    public List<Educacion> list(@RequestParam(required = false) String titulo) {
        if (!StringUtils.hasText(titulo)) {
            return educacionService.getAll();
        }
        return educacionService.findByTitulo(titulo);
    }

    @PostMapping
    public String save(@RequestBody EducacionRequest request) {
        return educacionService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody EducacionRequest request) {
        Optional<Educacion> ed = educacionService.findById(id);
        if (ed.isPresent()) {
            educacionService.update(id, request);
        } else {
            educacionService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        educacionService.delete(id);
    }
}
