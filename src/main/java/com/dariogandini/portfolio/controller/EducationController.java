package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Education;
import com.dariogandini.portfolio.repository.EducationRepository;
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
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @GetMapping("/list")
    public List<Education> list() {
        return educationRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Education> search(@PathVariable Long id) {
        Education education = educationRepository.findById(id).orElse(null);
        return ResponseEntity.ok(education);
    }

    @PostMapping("/add")
    public Education add(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Education> edit(@PathVariable Long id, @RequestBody Education educationDetails) {
        Education education = educationRepository.findById(id).orElse(null);
        education.setTitle(educationDetails.getTitle());
        education.setInstitution(educationDetails.getInstitution());
        education.setDate(educationDetails.getDate());
        education.setDuration(educationDetails.getDuration());
        education.setInstitutionLogo(educationDetails.getDuration());
        Education educacionModificada = educationRepository.save(education);
        return ResponseEntity.ok(educacionModificada);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") Long educationId) {
        Education education = educationRepository.findById(educationId).orElse(null);
        educationRepository.delete(education);
    }

}
