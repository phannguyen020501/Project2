package com.example.project2.controller;

import com.example.project2.model.Categories;
import com.example.project2.model.Suppliers;
import com.example.project2.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/suppliers/")
public class SuppliersController {

    @Autowired SuppliersService service;


    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Suppliers> read(@PathVariable(name = "id") int id){
        Suppliers suppliers = service.findById(id);
        if(suppliers == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(suppliers);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Suppliers> create(@RequestBody Suppliers suppliers){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        suppliers.setCreatedAt(ts);
        Suppliers suppliers1 = service.create(suppliers);
        if(suppliers1 == null){
            return ResponseEntity.notFound().build();
        }else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(suppliers1.getId()).toUri();
            return ResponseEntity.created(uri).body(suppliers1);
        }
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> update(@RequestBody Suppliers suppliers, @PathVariable int id) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        suppliers.setUpdatedAt(ts);

        Suppliers updated = service.update(id, suppliers);
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
