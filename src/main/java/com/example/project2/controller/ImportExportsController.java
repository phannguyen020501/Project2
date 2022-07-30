package com.example.project2.controller;

import com.example.project2.model.Generics;
import com.example.project2.model.ImportExports;
import com.example.project2.service.GenericsService;
import com.example.project2.service.ImportExportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/import_exports/")
public class ImportExportsController {
    @Autowired
    ImportExportsService importExportsService;

    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<ImportExports> read(@PathVariable(name = "id") int id){
        ImportExports importExports = importExportsService.findById(id);
        if(importExports == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(importExports);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<ImportExports> create(@RequestBody ImportExports importExports){


        ImportExports created = importExportsService.create(importExports);
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
    public ResponseEntity<ImportExports> update(@RequestBody ImportExports importExports, @PathVariable int id) {

        ImportExports updated = importExportsService.update(id, importExports);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = importExportsService.delete(id);
        return ResponseEntity.ok(check);
    }
}
