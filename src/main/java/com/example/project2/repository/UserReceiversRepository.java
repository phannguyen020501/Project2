package com.example.project2.repository;

import com.example.project2.model.UserReceivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReceiversRepository extends JpaRepository<UserReceivers, Integer> {
    public UserReceivers findById(int id);
}
