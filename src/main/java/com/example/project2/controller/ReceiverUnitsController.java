package com.example.project2.controller;

import com.example.project2.model.Militaryunits;
import com.example.project2.model.ReceiverUnits;
import com.example.project2.service.MilitaryunitsService;
import com.example.project2.service.ReceiverUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/receiver_units/")
public class ReceiverUnitsController {

    @Autowired
    ReceiverUnitsService service;


    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReceiverUnits> read(@PathVariable(name = "id") int id){

        ReceiverUnits receiverUnits = service.findById(id);
        if(receiverUnits == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(receiverUnits);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<ReceiverUnits> create(@RequestBody ReceiverUnits receiverUnits){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        receiverUnits.setCreateAt(ts);

        ReceiverUnits created = service.create(receiverUnits);
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
    public ResponseEntity<ReceiverUnits> update(@RequestBody ReceiverUnits receiverUnits, @PathVariable int id) {

        ReceiverUnits updated = service.update(id, receiverUnits);
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
