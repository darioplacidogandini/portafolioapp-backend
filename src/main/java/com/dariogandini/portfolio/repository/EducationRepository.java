package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {}
