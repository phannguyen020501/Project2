package com.example.project2.service;

import com.example.project2.model.*;
import com.example.project2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired MilitaryunitsService militaryunitsService;
    @Autowired WarehousesService warehousesService;

    public Users findById(int id){
        return usersRepository.findById(id);
    }
    public Users create(Users users){
        int miliId = users.getUnitId();
        Militaryunits militaryunits = militaryunitsService.findById(miliId);
        if(militaryunits == null){
            return null;
        }

        int warehouseid = users.getWarehouseId();
        Warehouses warehouses = warehousesService.findById(warehouseid);
        if(warehouses == null){
            return null;
        }

        users.setMilitaryunitsByUnitId(militaryunits);
        users.setWarehousesByWarehouseId(warehouses);
        usersRepository.save(users);
        return users;
    }

    public Users update(int id, Users users){

        int miliId = users.getUnitId();
        Militaryunits militaryunits = militaryunitsService.findById(miliId);
        if(militaryunits == null){
            return null;
        }

        int warehouseid = users.getWarehouseId();
        Warehouses warehouses = warehousesService.findById(warehouseid);
        if(warehouses == null){
            return null;
        }

        Users users1 = usersRepository.findById(id);
        if(users1 == null) return null;

        users.setId(users1.getId());
        users.setMilitaryunitsByUnitId(militaryunits);
        users.setWarehousesByWarehouseId(warehouses);
        users.setCreatedAt(users1.getCreatedAt());

        usersRepository.save(users);
        return users;
    }

    public boolean delete(int id){
        Users users = usersRepository.findById(id);
        if(users == null) return false;
        usersRepository.delete(users);
        return true;
    }
}
