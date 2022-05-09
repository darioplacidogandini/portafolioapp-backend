package com.dariogandini.portafolioapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portafolioapp.model.Educacion;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, String> {

    List<Educacion> findAllByTitleContaining(String titulo);
}
