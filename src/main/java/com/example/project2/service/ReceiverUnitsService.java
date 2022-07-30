package com.example.project2.service;

import com.example.project2.model.Militaryunits;
import com.example.project2.model.ReceiverUnits;
import com.example.project2.repository.MilitaryUnitsRepository;
import com.example.project2.repository.ReceiverUnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverUnitsService {
    @Autowired
    ReceiverUnitsRepository receiverUnitsRepository;

    public ReceiverUnits findById(int id){
        return receiverUnitsRepository.findById(id);
    }
    public ReceiverUnits create(ReceiverUnits receiverUnits){
        receiverUnitsRepository.save(receiverUnits);
        return receiverUnits;
    }

    public ReceiverUnits update(int id, ReceiverUnits receiverUnits){
        ReceiverUnits updated = receiverUnitsRepository.findById(id);
        if(updated == null) return null;
        receiverUnits.setId(updated.getId());
        receiverUnits.setCreateAt(updated.getCreateAt());
        receiverUnitsRepository.save(receiverUnits);
        return receiverUnits;
    }

    public boolean delete(int id){
        ReceiverUnits receiverUnits = receiverUnitsRepository.findById(id);
        if(receiverUnits == null) return false;
        receiverUnitsRepository.delete(receiverUnits);
        return true;
    }
}
