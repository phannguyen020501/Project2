package com.example.project2.repository;

import com.example.project2.model.Generics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericsRepository extends JpaRepository<Generics, Integer> {
    public Generics findById(int id);
}
