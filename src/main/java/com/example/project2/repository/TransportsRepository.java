package com.example.project2.repository;

import com.example.project2.model.Transports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportsRepository extends JpaRepository<Transports, Integer> {
    public Transports findById(int id);
}
