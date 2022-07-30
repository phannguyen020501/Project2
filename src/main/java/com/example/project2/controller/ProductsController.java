package com.example.project2.controller;


import com.example.project2.model.Generics;
import com.example.project2.model.Products;
import com.example.project2.service.GenericsService;
import com.example.project2.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/products/")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Products> read(@PathVariable(name = "id") int id){
        Products products = productsService.findById(id);
        if(products == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(products);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Products> create(@RequestBody Products products){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        products.setCreatedAt(ts);

        Products created = productsService.create(products);
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
    public ResponseEntity<Products> update(@RequestBody Products products, @PathVariable int id) {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        products.setUpdatedAt(ts);


        Products updated = productsService.update(id, products);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = productsService.delete(id);
        return ResponseEntity.ok(check);
    }
}
