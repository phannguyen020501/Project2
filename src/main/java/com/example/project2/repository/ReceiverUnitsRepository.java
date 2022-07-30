package com.example.project2.repository;

import com.example.project2.model.ReceiverUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverUnitsRepository extends JpaRepository<ReceiverUnits, Integer> {
    public ReceiverUnits findById(int id);
}
