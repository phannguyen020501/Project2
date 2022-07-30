package com.example.project2.controller;

import com.example.project2.model.Militaryunits;
import com.example.project2.model.Suppliers;
import com.example.project2.service.MilitaryunitsService;
import com.example.project2.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/military/")
public class MilitaryController {

    @Autowired
    MilitaryunitsService service;


    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Militaryunits> read(@PathVariable(name = "id") int id){
        Militaryunits militaryunits = service.findById(id);
        if(militaryunits == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(militaryunits);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Militaryunits> create(@RequestBody Militaryunits militaryunits){

        Militaryunits created = service.create(militaryunits);
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
    public ResponseEntity<Militaryunits> update(@RequestBody Militaryunits militaryunits, @PathVariable int id) {

        Militaryunits updated = service.update(id, militaryunits);
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

