package com.example.project2.service;

import com.example.project2.model.UserReceivers;
import com.example.project2.model.Warehouses;
import com.example.project2.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousesService {

    @Autowired
    WarehousesRepository warehousesRepository;

    public Warehouses findById(int id){
        return warehousesRepository.findById(id);
    }
    public Warehouses create(Warehouses warehouses){
        warehousesRepository.save(warehouses);
        return warehouses;
    }

    public Warehouses update(int id, Warehouses warehouses){
        Warehouses updated = warehousesRepository.findById(id);
        if(updated == null) return null;
        warehouses.setId(updated.getId());
        warehouses.setCreatedAt(updated.getCreatedAt());
        warehousesRepository.save(warehouses);

        return warehouses;
    }

    public boolean delete(int id){
        Warehouses warehouses = warehousesRepository.findById(id);
        if(warehouses == null) return false;
        warehousesRepository.delete(warehouses);
        return true;
    }
}
