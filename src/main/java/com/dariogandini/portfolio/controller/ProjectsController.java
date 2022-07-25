package com.dariogandini.portfolio.controller;

import java.util.List;

import com.dariogandini.portfolio.model.Projects;
import com.dariogandini.portfolio.repository.ProjectsRepository;

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
@RequestMapping("/api/projects")
public class ProjectsController {

    @Autowired
    private ProjectsRepository projectsRepository;

    @GetMapping("/list")
    public List<Projects> list() {
        return projectsRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Projects> search(@PathVariable Long id) {
        Projects projects = projectsRepository.findById(id).orElse(null);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/add")
    public Projects add(@RequestBody Projects projects) {
        return projectsRepository.save(projects);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Projects> edit(@PathVariable Long id, @RequestBody Projects project) {
        Projects projects = projectsRepository.findById(id).orElse(null);
        projects.setProjectName(project.getProjectName());
        projects.setDescription(project.getDescription());
        projects.setProjectLogo(project.getProjectLogo());
        projects.setProjectURL(project.getProjectURL());
        projects.setSourceCode(project.getSourceCode());
        Projects proyectoModificado = projectsRepository.save(projects);
        return ResponseEntity.ok(proyectoModificado);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long projectsId) {
        Projects projects = projectsRepository.findById(projectsId).orElse(null);
        projectsRepository.delete(projects);
    }
    
}
