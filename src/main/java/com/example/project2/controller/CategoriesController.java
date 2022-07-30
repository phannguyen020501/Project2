package com.example.project2.controller;


import com.example.project2.model.Categories;
import com.example.project2.service.CategoriesService;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping(value = "admin/categories/")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categories> read(@PathVariable(name = "id") int id){
        Categories categories = categoriesService.findCategoriesById(id);
        if(categories == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(categories);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Categories> create(@RequestBody Categories categories){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        categories.setCreatedAt(ts);
        Categories createCategories = categoriesService.create(categories);
        if(createCategories == null){
            return ResponseEntity.notFound().build();
        }else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createCategories.getId()).toUri();
            return ResponseEntity.created(uri).body(createCategories);
        }
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Categories> update(@RequestBody Categories categories, @PathVariable int id) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        categories.setUpdatedAt(ts);

        Categories updated = categoriesService.update(id, categories);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = categoriesService.delete(id);
        return ResponseEntity.ok(check);
    }




}
