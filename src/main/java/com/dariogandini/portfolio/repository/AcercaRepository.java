package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.Acerca;

@Repository
public interface AcercaRepository extends JpaRepository<Acerca, Long> {

}
