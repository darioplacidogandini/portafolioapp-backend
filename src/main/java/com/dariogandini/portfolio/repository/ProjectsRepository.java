package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {}
