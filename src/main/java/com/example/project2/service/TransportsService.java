package com.example.project2.service;

import com.example.project2.model.Categories;
import com.example.project2.model.Transports;
import com.example.project2.repository.CategoriesRepository;
import com.example.project2.repository.TransportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportsService {

    @Autowired
    private TransportsRepository transportsRepository;

    public Transports findTransportById(int id){
        return transportsRepository.findById(id);
    }
    public Transports create(Transports transports){
        transportsRepository.save(transports);
        return transports;
    }

    public Transports update(int id, Transports transports){
        Transports transports1 = transportsRepository.findById(id);
        if(transports1 == null) return null;
        transports.setId(transports1.getId());
        transportsRepository.save(transports);
        return transports;
    }

    public boolean delete(int id){
        Transports transports = transportsRepository.findById(id);
        if(transports == null) return false;
        transportsRepository.delete(transports);
        return true;
    }
}
