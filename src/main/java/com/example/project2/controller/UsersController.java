package com.example.project2.controller;


import com.example.project2.model.Generics;
import com.example.project2.model.Users;
import com.example.project2.service.GenericsService;
import com.example.project2.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/users/")
public class UsersController {

    @Autowired
    private UsersService usersService;


    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> read(@PathVariable(name = "id") int id){
        Users users = usersService.findById(id);
        if(users == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(users);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Users> create(@RequestBody Users users){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        users.setCreatedAt(ts);

        Users created = usersService.create(users);
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
    public ResponseEntity<Users> update(@RequestBody Users users, @PathVariable int id) {

        Users updated = usersService.update(id, users);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = usersService.delete(id);
        return ResponseEntity.ok(check);
    }

}
