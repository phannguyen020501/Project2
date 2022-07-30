package com.example.project2.service;

import com.example.project2.model.Militaryunits;
import com.example.project2.model.Suppliers;
import com.example.project2.repository.MilitaryUnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilitaryunitsService {
    @Autowired MilitaryUnitsRepository militaryUnitsRepository;

    public Militaryunits findById(int id){
        return militaryUnitsRepository.findById(id);
    }
    public Militaryunits create(Militaryunits militaryunits){
        militaryUnitsRepository.save(militaryunits);
        return militaryunits;
    }

    public Militaryunits update(int id, Militaryunits militaryunits){
        Militaryunits updated = militaryUnitsRepository.findById(id);
        if(updated == null) return null;
        militaryunits.setId(updated.getId());

        militaryUnitsRepository.save(militaryunits);
        return militaryunits;
    }

    public boolean delete(int id){
        Militaryunits militaryunits = militaryUnitsRepository.findById(id);
        if(militaryunits == null) return false;
        militaryUnitsRepository.delete(militaryunits);
        return true;
    }
}
