package com.example.project2.controller;

import com.example.project2.model.Categories;
import com.example.project2.model.Transports;
import com.example.project2.service.TransportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/transports/")
public class TransportsController {

    @Autowired TransportsService transportsService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transports> read(@PathVariable(name = "id") int id){
        Transports transports = transportsService.findTransportById(id);
        if(transports == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(transports);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Transports> create(@RequestBody Transports transports){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        transports.setCreatedAt(ts);
        Transports transports1 = transportsService.create(transports);
        if(transports1 == null){
            return ResponseEntity.notFound().build();
        }else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(transports1.getId()).toUri();
            return ResponseEntity.created(uri).body(transports1);
        }
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Transports> update(@RequestBody Transports transports, @PathVariable int id) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        transports.setUpdatedAt(ts);

        Transports updated = transportsService.update(id, transports);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = transportsService.delete(id);
        return ResponseEntity.ok(check);
    }
}
