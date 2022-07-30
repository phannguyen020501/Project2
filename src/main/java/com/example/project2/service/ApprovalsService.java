package com.example.project2.service;

import com.example.project2.model.Approvals;
import com.example.project2.model.Militaryunits;
import com.example.project2.model.Users;
import com.example.project2.model.Warehouses;
import com.example.project2.repository.ApprovalsRepository;
import com.example.project2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ApprovalsService {

    @Autowired
    private ApprovalsRepository approvalsRepository;
    @Autowired UsersService usersService;

    public Approvals findById(int id){
        return approvalsRepository.findById(id);
    }
    public Approvals create(Approvals approvals){
        int usersId = approvals.getAcceptedBy();
        Users users = usersService.findById(usersId);
        if(users == null){
            return null;
        }

        approvals.setUsersByAcceptedBy(users);
        approvalsRepository.save(approvals);
        return approvals;
    }

    public Approvals update(int id, Approvals approvals){

        int usersId = approvals.getAcceptedBy();
        Users users = usersService.findById(usersId);
        if(users == null){
            return null;
        }

        Approvals approvals1 = approvalsRepository.findById(id);
        if(approvals1 == null) return null;

        approvals.setId(approvals1.getId());
        approvals.setUsersByAcceptedBy(users);
        approvals.setCreatedAt(approvals1.getCreatedAt());

        approvalsRepository.save(approvals);
        return approvals;
    }

    public boolean delete(int id){
        Approvals approvals = approvalsRepository.findById(id);
        if(approvals == null) return false;
        approvalsRepository.delete(approvals);
        return true;
    }
}
