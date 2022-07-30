package com.example.project2.controller;


import com.example.project2.model.Militaryunits;
import com.example.project2.model.Warehouses;
import com.example.project2.service.MilitaryunitsService;
import com.example.project2.service.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/warehouses/")
public class WarehousesController {
    @Autowired WarehousesService service;

    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Warehouses> read(@PathVariable(name = "id") int id){
        Warehouses warehouses = service.findById(id);
        if(warehouses == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(warehouses);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Warehouses> create(@RequestBody Warehouses warehouses){

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        warehouses.setCreatedAt(ts);

        Warehouses created = service.create(warehouses);
        if(created == null){
            return ResponseEntity.notFound().build();
        }else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(created.getId()).toUri();
            return ResponseEntity.created(uri).body(created);
        }
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Warehouses> update(@RequestBody Warehouses warehouses, @PathVariable int id) {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        warehouses.setUpdatedAt(ts);


        Warehouses updated = service.update(id, warehouses);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = service.delete(id);
        return ResponseEntity.ok(check);
    }

}
