package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.Afiliados;

@Repository
public interface AfiliadosRepository extends JpaRepository<Afiliados, Long> {}
