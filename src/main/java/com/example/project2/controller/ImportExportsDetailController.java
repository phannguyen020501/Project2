package com.example.project2.controller;

import com.example.project2.model.ImportExports;
import com.example.project2.model.ImportExportsDetails;
import com.example.project2.service.ImportExportsDetailsService;
import com.example.project2.service.ImportExportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "admin/import_exports_detail/")
public class ImportExportsDetailController {
    @Autowired
    ImportExportsDetailsService importExportsDetailsService;

    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<ImportExportsDetails> read(@PathVariable(name = "id") int id){
        ImportExportsDetails importExportsDetails = importExportsDetailsService.findById(id);
        if(importExportsDetails == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(importExportsDetails);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<ImportExportsDetails> create(@RequestBody ImportExportsDetails importExportsDetails){


        ImportExportsDetails created = importExportsDetailsService.create(importExportsDetails);
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
    public ResponseEntity<ImportExportsDetails> update(@RequestBody ImportExportsDetails importExportsDetails, @PathVariable int id) {

        ImportExportsDetails updated = importExportsDetailsService.update(id, importExportsDetails);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = importExportsDetailsService.delete(id);
        return ResponseEntity.ok(check);
    }
}
