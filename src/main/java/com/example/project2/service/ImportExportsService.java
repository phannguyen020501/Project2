package com.example.project2.service;

import com.example.project2.model.*;
import com.example.project2.repository.ImportExportsRepository;
import com.example.project2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportExportsService {

    @Autowired
    private ImportExportsRepository importExportsRepository;
    @Autowired WarehousesService warehousesService;
    @Autowired SuppliersService suppliersService;
    @Autowired TransportsService transportsService;
    @Autowired ReceiverUnitsService receiverUnitsService;
    @Autowired UserReceiversService userReceiversService;
    @Autowired UsersService usersService;

    public ImportExports findById(int id){
        return importExportsRepository.findById(id);
    }
    public ImportExports create(ImportExports importExports){
        int warehouse_id = importExports.getWarehouseId();
        Warehouses warehouses = warehousesService.findById(warehouse_id);
        if(warehouses == null) return null;

        int supplier_id = importExports.getSupplierId();
        Suppliers suppliers = suppliersService.findById(supplier_id);
        if(suppliers == null) return null;

        int transport_id = importExports.getTransportId();
        Transports transports = transportsService.findTransportById(transport_id);
        if(transports == null) return null;

        int receiver_unit_id = importExports.getReceiverUnitId();
        ReceiverUnits receiverUnits = receiverUnitsService.findById(receiver_unit_id);
        if(receiverUnits == null) return null;

        int user_receiver_id = importExports.getUserReceiverId();
        UserReceivers userReceivers = userReceiversService.findById(user_receiver_id);
        if(userReceivers == null) return null;

        int created_by = importExports.getCreatedBy();
        Users users = usersService.findById(created_by);
        if(users == null) return null;



        importExports.setWarehousesByWarehouseId(warehouses);
        importExports.setSuppliersBySupplierId(suppliers);
        importExports.setTransportsByTransportId(transports);
        importExports.setReceiverUnitsByReceiverUnitId(receiverUnits);
        importExports.setUserReceiversByUserReceiverId(userReceivers);
        importExports.setUsersByCreatedBy(users);

        importExportsRepository.save(importExports);
        return importExports;
    }

    public ImportExports update(int id, ImportExports importExports){
        ImportExports checked = importExportsRepository.findById(id);

        if(checked == null) return null;


        int warehouse_id = importExports.getWarehouseId();
        Warehouses warehouses = warehousesService.findById(warehouse_id);
        if(warehouses == null) return null;

        int supplier_id = importExports.getSupplierId();
        Suppliers suppliers = suppliersService.findById(supplier_id);
        if(suppliers == null) return null;

        int transport_id = importExports.getTransportId();
        Transports transports = transportsService.findTransportById(transport_id);
        if(transports == null) return null;

        int receiver_unit_id = importExports.getReceiverUnitId();
        ReceiverUnits receiverUnits = receiverUnitsService.findById(receiver_unit_id);
        if(receiverUnits == null) return null;

        int user_receiver_id = importExports.getUserReceiverId();
        UserReceivers userReceivers = userReceiversService.findById(user_receiver_id);
        if(userReceivers == null) return null;

        int created_by = importExports.getCreatedBy();
        Users users = usersService.findById(created_by);
        if(users == null) return null;



        importExports.setWarehousesByWarehouseId(warehouses);
        importExports.setSuppliersBySupplierId(suppliers);
        importExports.setTransportsByTransportId(transports);
        importExports.setReceiverUnitsByReceiverUnitId(receiverUnits);
        importExports.setUserReceiversByUserReceiverId(userReceivers);
        importExports.setUsersByCreatedBy(users);
        importExports.setId(checked.getId());
        importExportsRepository.save(importExports);
        return importExports;
    }

    public boolean delete(int id){
        ImportExports importExports = importExportsRepository.findById(id);
        if(importExports == null) return false;
        importExportsRepository.delete(importExports);
        return true;
    }
}
