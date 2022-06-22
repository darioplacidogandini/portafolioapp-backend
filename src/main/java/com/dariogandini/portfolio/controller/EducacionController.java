package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Educacion;
import com.dariogandini.portfolio.repository.EducacionRepository;
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
@RequestMapping("/api/educacion")
public class EducacionController {

    @Autowired
    private EducacionRepository educacionRepository;

    @GetMapping("/listar")
    public List<Educacion> listar() {
        return educacionRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> buscar(@PathVariable Long id) {
        Educacion educacion = educacionRepository.findById(id).orElse(null);
        return ResponseEntity.ok(educacion);
    }

    @PostMapping("/agregar")
    public Educacion agregar(@RequestBody Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Educacion> editar(@PathVariable Long id, @RequestBody Educacion detallesEducacion) {
        Educacion educacion = educacionRepository.findById(id).orElse(null);
        educacion.setTitulo(detallesEducacion.getTitulo());
        educacion.setInstitucion(detallesEducacion.getInstitucion());
        educacion.setFecha(detallesEducacion.getFecha());
        educacion.setDuracion(detallesEducacion.getDuracion());
        educacion.setLogo(detallesEducacion.getLogo());
        Educacion educacionModificada = educacionRepository.save(educacion);
        return ResponseEntity.ok(educacionModificada);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable(value="id") Long educacionId) {
        Educacion educacion = educacionRepository.findById(educacionId).orElse(null);
        educacionRepository.delete(educacion);
    }

}
