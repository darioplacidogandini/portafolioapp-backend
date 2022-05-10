package com.dariogandini.portafolioapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dariogandini.portafolioapp.model.Educacion;
import com.dariogandini.portafolioapp.model.EducacionRequest;
import com.dariogandini.portafolioapp.repository.EducacionRepository;

@Service
public class EducacionService {

    private final EducacionRepository educacionRepository;

    @Autowired
    public EducacionService(EducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }

    public Optional<Educacion> findById(String id) {
        return educacionRepository.findById(id);
    }

    public String save(EducacionRequest request) {
        Educacion ed = new Educacion();
        ed.setTitulo(request.getTitulo());
        ed.setInstitucion(request.getInstitucion());
        return educacionRepository.save(ed).getId();
    }

    public void update(String id, EducacionRequest request) {
        Optional<Educacion> ed = findById(id);
        if (ed.isPresent()) {
            Educacion forUpdate = ed.get();
            forUpdate.setTitulo(request.getTitulo());
            forUpdate.setInstitucion(request.getInstitucion());
            educacionRepository.save(forUpdate);
        }
    }

    public List<Educacion> getAll() {
        return educacionRepository.findAll();
    }

    public List<Educacion> findByTitulo(String titulo) {
        return educacionRepository.findAllByTituloContaining(titulo);
    }

    public void delete(String id) {
        Optional<Educacion> ed = findById(id);
        ed.ifPresent(educacionRepository::delete);
    }
}