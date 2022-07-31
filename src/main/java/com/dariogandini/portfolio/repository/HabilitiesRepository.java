package com.dariogandini.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.portfolio.model.Habilities;

@Repository
public interface HabilitiesRepository extends JpaRepository<Habilities,Long> {}
