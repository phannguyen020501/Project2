package com.example.project2.controller;

import com.example.project2.model.Generics;
import com.example.project2.model.Militaryunits;
import com.example.project2.service.GenericsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "/admin/generics/")
public class GenericsController {

    @Autowired GenericsService genericsService;

    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Generics> read(@PathVariable(name = "id") int id){
        Generics generics = genericsService.findById(id);
        if(generics == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(generics);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Generics> create(@RequestBody Generics generics){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        generics.setCreatedAt(ts);

        System.out.println(generics);
        Generics created = genericsService.create(generics);
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
    public ResponseEntity<Generics> update(@RequestBody Generics generics, @PathVariable int id) {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        generics.setUpdatedAt(ts);


        Generics updated = genericsService.update(id, generics);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = genericsService.delete(id);
        return ResponseEntity.ok(check);
    }
}
