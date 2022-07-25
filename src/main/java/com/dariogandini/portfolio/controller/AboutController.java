package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.About;
import com.dariogandini.portfolio.repository.AboutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"https://dariogandini-portfoliofrontend.firebaseapp.com",
"https://dariogandini-portfoliofrontend.web.app"})
@RestController
@RequestMapping("/api/about")
public class AboutController {

    @Autowired
    private AboutRepository aboutRepository;

    @GetMapping("/list")
    public List<About> list() {
        return aboutRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<About> search(@PathVariable Long id) {
        About about = aboutRepository.findById(id).orElse(null);
        return ResponseEntity.ok(about);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<About> edit(@PathVariable Long id, 
    @RequestBody About aboutDetails) {
        About about = aboutRepository.findById(id).orElse(null);
        about.setName(aboutDetails.getName());
        about.setJob(aboutDetails.getJob());
        about.setProfilePhoto(aboutDetails.getProfilePhoto());
        about.setProfilePhoto(aboutDetails.getProfilePhoto());
        About editedAbout = aboutRepository.save(about);
        return ResponseEntity.ok(editedAbout);
    }
}

