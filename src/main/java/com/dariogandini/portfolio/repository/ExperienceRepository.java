package com.dariogandini.portfolio.repository;

import com.dariogandini.portfolio.model.Experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {}
