package com.example.project2.service;

import com.example.project2.model.Militaryunits;
import com.example.project2.model.UserReceivers;
import com.example.project2.repository.MilitaryUnitsRepository;
import com.example.project2.repository.UserReceiversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReceiversService {
    @Autowired
    UserReceiversRepository userReceiversRepository;

    public UserReceivers findById(int id){
        return userReceiversRepository.findById(id);
    }
    public UserReceivers create(UserReceivers userReceivers){
        userReceiversRepository.save(userReceivers);
        return userReceivers;
    }

    public UserReceivers update(int id, UserReceivers userReceivers){
        UserReceivers updated = userReceiversRepository.findById(id);
        if(updated == null) return null;
        userReceivers.setId(updated.getId());

        userReceiversRepository.save(userReceivers);
        return userReceivers;
    }

    public boolean delete(int id){
        UserReceivers userReceivers = userReceiversRepository.findById(id);
        if(userReceivers == null) return false;
        userReceiversRepository.delete(userReceivers);
        return true;
    }
}
