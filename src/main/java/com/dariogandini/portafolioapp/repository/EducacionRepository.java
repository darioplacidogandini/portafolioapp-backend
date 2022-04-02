package com.dariogandini.portafolioapp.repository;

import com.dariogandini.portafolioapp.model.Educacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    
}
