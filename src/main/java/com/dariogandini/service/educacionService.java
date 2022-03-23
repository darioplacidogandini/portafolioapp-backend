package com.dariogandini.service;

import java.util.List;

import com.dariogandini.model.educacion;
import com.dariogandini.repository.educacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class educacionService implements interfaceEducacionService {

    @Autowired
    private educacionRepository educacionRepository;

    @Override
    public List<educacion> getEducacionList() {
        List<educacion> listaEducacion = educacionRepository.findAll();
        return listaEducacion;
    }

    @Override
    public void saveEducacion(educacion edu) {
        educacionRepository.save(edu);
    }

    @Override
    public void deleteEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public educacion findEducacion(Long id) {
        educacion edu = educacionRepository.findById(id).orElse(null);
        return edu;
    }
}
