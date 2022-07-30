package com.example.project2.repository;

import com.example.project2.model.Militaryunits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilitaryUnitsRepository extends JpaRepository<Militaryunits, Integer> {
    public Militaryunits findById(int id);
}
