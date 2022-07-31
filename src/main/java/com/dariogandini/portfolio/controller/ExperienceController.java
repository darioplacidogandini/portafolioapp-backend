package com.dariogandini.portfolio.controller;

import java.util.List;

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

import com.dariogandini.portfolio.model.Experience;
import com.dariogandini.portfolio.repository.ExperienceRepository;

@CrossOrigin(origins = {"https://dariogandini-portfoliofrontend.firebaseapp.com",
"https://dariogandini-portfoliofrontend.web.app"})
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    
    @Autowired
    private ExperienceRepository experienceRepository;

    @GetMapping("/list")
    public List<Experience> list() {
        return experienceRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Experience> search(@PathVariable Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        return ResponseEntity.ok(experience);
    }

    @PostMapping("/add")
	public Experience add(@RequestBody Experience experience) {
		return experienceRepository.save(experience);
	}

    @PutMapping("/edit/{id}")
    public ResponseEntity<Experience> edit(@PathVariable Long id, 
    @RequestBody Experience experienceDetails) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        experience.setCompany(experienceDetails.getCompany());
        experience.setJob(experienceDetails.getJob());
        experience.setStart(experienceDetails.getStart());
        experience.setEnd(experienceDetails.getEnd());
        Experience editedExperience = experienceRepository.save(experience);
        return ResponseEntity.ok(editedExperience);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        experienceRepository.delete(experience);
    }
}
