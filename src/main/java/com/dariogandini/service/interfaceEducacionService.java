package com.dariogandini.service;

import java.util.List;

import com.dariogandini.model.educacion;

public interface interfaceEducacionService {
    public List<educacion> getEducacionList();

    public void saveEducacion (educacion educacion);

    public void deleteEducacion (Long id);

    public educacion findEducacion (Long id);
}
