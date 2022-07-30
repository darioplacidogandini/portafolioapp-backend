package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.About;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {}
