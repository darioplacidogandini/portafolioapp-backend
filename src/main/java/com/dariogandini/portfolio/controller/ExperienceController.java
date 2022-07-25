package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Experience;
import com.dariogandini.portfolio.repository.ExperienceRepository;

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

@CrossOrigin(origins = {"https://dariogandini-portfoliofrontend.firebaseapp.com",
"https://dariogandini-portfoliofrontend.web.app"})
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    
    @Autowired
    private ExperienceRepository experienciaRepository;

    @GetMapping("/list")
    public List<Experience> list() {
        return experienciaRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Experience> search(@PathVariable Long id) {
        Experience experience = experienciaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(experience);
    }

    @PostMapping("/add")
    public Experience add(@RequestBody Experience experience) {
        return experienciaRepository.save(experience);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Experience> edit(@PathVariable Long id, @RequestBody Experience detallesExperiencia) {
        Experience experience = experienciaRepository.findById(id).orElse(null);
        experience.setCompany(detallesExperiencia.getCompany());
        experience.setJob(detallesExperiencia.getJob());
        experience.setStart(detallesExperiencia.getStart());
        experience.setEnd(detallesExperiencia.getEnd());
        experience.setCompanyLogo(detallesExperiencia.getCompanyLogo());
        Experience experienciaModificada = experienciaRepository.save(experience);
        return ResponseEntity.ok(experienciaModificada);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long experienciaId) {
        Experience experience = experienciaRepository.findById(experienciaId).orElse(null);
        experienciaRepository.delete(experience);
    }

}
