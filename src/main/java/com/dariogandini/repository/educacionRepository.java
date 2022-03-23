package com.dariogandini.repository;

import com.dariogandini.model.educacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface educacionRepository extends JpaRepository <educacion, Long> {
    
}
