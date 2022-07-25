package com.dariogandini.portfolio.repository;

import com.dariogandini.portfolio.model.Habilities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilitiesRepository extends JpaRepository<Habilities, Long> {}
