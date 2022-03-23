package com.dariogandini.controller;

import java.util.List;

import com.dariogandini.model.educacion;
import com.dariogandini.service.interfaceEducacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class educacionController {
    
    @Autowired
    private interfaceEducacionService interEdu;
    
    @GetMapping ("/educacion/mostrar")
    public List<educacion> getEducacionList() {
        return interEdu.getEducacionList();
    }

    @PostMapping("/educacion/agregar")
    public String agregarEducacion(@RequestBody educacion edu) {
        interEdu.saveEducacion(edu);
        return "Educacion agregada correctamente";
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public String eliminarEducacion (@PathVariable Long id) {
        interEdu.deleteEducacion(id);
        return "Educacion eliminads correctamente";
    }

    @PutMapping ("/educacion/editar/{id}")
    public educacion editarEducacion (@PathVariable Long id,
        @RequestParam ("titulo") String nuevoTitulo,
        @RequestParam ("institucion") String nuevaInstitucion) {
            educacion edu = interEdu.findEducacion(id);
            edu.setTitulo(nuevoTitulo);
            edu.setInstitucion(nuevaInstitucion);
            interEdu.saveEducacion(edu);
            return edu;
    }
}
