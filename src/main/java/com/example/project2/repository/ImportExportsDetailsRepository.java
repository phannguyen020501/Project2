package com.example.project2.repository;

import com.example.project2.model.ImportExportsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportExportsDetailsRepository extends JpaRepository<ImportExportsDetails, Integer> {
    public ImportExportsDetails findById(int id);
}
