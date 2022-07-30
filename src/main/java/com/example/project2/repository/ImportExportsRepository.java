package com.example.project2.repository;

import com.example.project2.model.ImportExports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportExportsRepository extends JpaRepository<ImportExports, Integer> {
    public ImportExports findById(int id);
}
