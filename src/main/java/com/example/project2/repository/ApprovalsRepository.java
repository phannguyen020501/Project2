package com.example.project2.repository;

import com.example.project2.model.Approvals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalsRepository extends JpaRepository<Approvals,Integer> {
    public Approvals findById(int id);
}
