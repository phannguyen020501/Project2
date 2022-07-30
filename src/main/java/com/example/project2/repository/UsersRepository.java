package com.example.project2.repository;

import com.example.project2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    public Users findById(int id);
    public List<Users> findByUnitId(int unitId);
    public List<Users> findByWarehouseId(int warehouseId);
}
