package com.example.project2.repository;

import com.example.project2.model.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, Integer> {
    public Warehouses findById(int id);
}
