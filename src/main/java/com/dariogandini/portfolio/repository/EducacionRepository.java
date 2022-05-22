package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.Educacion;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

}
