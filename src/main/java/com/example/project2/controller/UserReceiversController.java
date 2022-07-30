package com.example.project2.controller;

import com.example.project2.model.Militaryunits;
import com.example.project2.model.UserReceivers;
import com.example.project2.service.MilitaryunitsService;
import com.example.project2.service.UserReceiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "admin/user_receivers/")
public class UserReceiversController {

    @Autowired
    UserReceiversService service;


    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserReceivers> read(@PathVariable(name = "id") int id){
        UserReceivers userReceivers = service.findById(id);
        if(userReceivers == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(userReceivers);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<UserReceivers> create(@RequestBody UserReceivers userReceivers){

        UserReceivers created = service.create(userReceivers);
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
    public ResponseEntity<UserReceivers> update(@RequestBody UserReceivers userReceivers, @PathVariable int id) {

        UserReceivers updated = service.update(id, userReceivers);
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
