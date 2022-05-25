package com.dariogandini.portfolio.repository;

import com.dariogandini.portfolio.model.Habilidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
    
}
