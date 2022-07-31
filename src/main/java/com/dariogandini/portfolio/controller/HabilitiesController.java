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

import com.dariogandini.portfolio.model.Habilities;
import com.dariogandini.portfolio.repository.HabilitiesRepository;

@CrossOrigin(origins = {"https://dariogandini-portfoliofrontend.firebaseapp.com",
"https://dariogandini-portfoliofrontend.web.app"})
@RestController
@RequestMapping("/api/habilities")
public class HabilitiesController {
    
    @Autowired
    private HabilitiesRepository habilitiesRepository;

    @GetMapping("/list")
    public List<Habilities> list() {
        return habilitiesRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Habilities> search(@PathVariable Long id) {
        Habilities education = habilitiesRepository.findById(id).orElse(null);
        return ResponseEntity.ok(education);
    }

    @PostMapping("/add")
	public Habilities add(@RequestBody Habilities habilities) {
		return habilitiesRepository.save(habilities);
	}

    @PutMapping("/edit/{id}")
    public ResponseEntity<Habilities> edit(@PathVariable Long id, 
    @RequestBody Habilities habilitiesDetails) {
        Habilities habilities = habilitiesRepository.findById(id).orElse(null);
        habilities.setHability(habilitiesDetails.getHability());
        habilities.setPercentage(habilitiesDetails.getPercentage());
        Habilities editedHabilities = habilitiesRepository.save(habilities);
        return ResponseEntity.ok(editedHabilities);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value="id") Long id) {
        Habilities habilities = habilitiesRepository.findById(id).orElse(null);
        habilitiesRepository.delete(habilities);
    }
}
