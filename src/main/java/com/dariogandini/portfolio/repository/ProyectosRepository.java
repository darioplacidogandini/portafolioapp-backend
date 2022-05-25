package com.dariogandini.portfolio.repository;

import com.dariogandini.portfolio.model.Proyectos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectosRepository extends JpaRepository<Proyectos, Long> {
    
}
