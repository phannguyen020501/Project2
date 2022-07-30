package com.example.project2.service;

import com.example.project2.model.Suppliers;
import com.example.project2.model.Transports;
import com.example.project2.repository.SuppliersRepository;
import com.example.project2.repository.TransportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    public Suppliers findById(int id){
        return suppliersRepository.findById(id);
    }
    public Suppliers create(Suppliers suppliers){
        suppliersRepository.save(suppliers);
        return suppliers;
    }

    public Suppliers update(int id, Suppliers suppliers){
        Suppliers suppliers1 = suppliersRepository.findById(id);
        if(suppliers1 == null) return null;
        suppliers.setId(suppliers1.getId());
        suppliers.setCreatedAt(suppliers1.getCreatedAt());
        suppliersRepository.save(suppliers);
        return suppliers;
    }

    public boolean delete(int id){
        Suppliers suppliers = suppliersRepository.findById(id);
        if(suppliers == null) return false;
        suppliersRepository.delete(suppliers);
        return true;
    }
}
