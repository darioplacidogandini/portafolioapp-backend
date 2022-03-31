package com.dariogandini.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dariogandini.exception.RecursoNoEncontradoExepcion;
import com.dariogandini.model.Educacion;
import com.dariogandini.repository.EducacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EducacionController {

    @Autowired
    private EducacionRepository educacionRepository;

    @GetMapping("/educacion")
    public List <Educacion> getAllEducacion() {
        return educacionRepository.findAll();
    }

    @GetMapping("/educacion/{id}") 
    public ResponseEntity <Educacion> getEducacionById(@PathVariable(value = "id") Long educacionId) 
    throws RecursoNoEncontradoExepcion {
        Educacion educacion = educacionRepository.findById(educacionId).orElseThrow(() -> 
        new RecursoNoEncontradoExepcion("No se encontro educacion con el id: " + educacionId));
        return ResponseEntity.ok().body(educacion);
    }

    @PostMapping("/agregarEducacion")
    public Educacion agregarEducacion(@RequestBody Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @PutMapping("/educacion/{id}")
    public ResponseEntity <Educacion> actualizarEducacion(@PathVariable(value = "id") Long educacionId,
    @RequestBody Educacion detallesEducacion) throws RecursoNoEncontradoExepcion {
        Educacion educacion = educacionRepository.findById(educacionId).orElseThrow(() ->
        new RecursoNoEncontradoExepcion("No se encontro educacion con el id: " + educacionId));
        educacion.setTitulo(detallesEducacion.getInstitucion());
        educacion.setInstitucion(detallesEducacion.getInstitucion());
        final Educacion educacionActualizada = educacionRepository.save(educacion);
        return ResponseEntity.ok(educacionActualizada);
    }

    @DeleteMapping("/educacion/{id}")
    public Map <String, Boolean> eliminarEducacion(@PathVariable(value = "id") Long educacionId)
    throws RecursoNoEncontradoExepcion {
        Educacion educacion = educacionRepository.findById(educacionId).orElseThrow(()
        -> new RecursoNoEncontradoExepcion("No se encontro educacioncon el id: " + educacionId));

        educacionRepository.delete(educacion);
        Map <String, Boolean> response = new HashMap <> ();
        response.put("Educacion eliminada", Boolean.TRUE);
        return response;
    }
}
