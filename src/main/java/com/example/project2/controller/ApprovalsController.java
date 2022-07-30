package com.example.project2.controller;

import com.example.project2.model.Approvals;
import com.example.project2.model.Users;
import com.example.project2.service.ApprovalsService;
import com.example.project2.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "admin/approvals/")

public class ApprovalsController {

    @Autowired
    private ApprovalsService approvalsService;


    //tim
    @GetMapping(value = "/{id}")
    public ResponseEntity<Approvals> read(@PathVariable(name = "id") int id){
        Approvals approvals = approvalsService.findById(id);
        if(approvals == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(approvals);
        }
    }

    //them,
    @PostMapping("/")
    public ResponseEntity<Approvals> create(@RequestBody Approvals approvals){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        approvals.setCreatedAt(ts);

        Approvals created = approvalsService.create(approvals);
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
    public ResponseEntity<Approvals> update(@RequestBody Approvals approvals, @PathVariable int id) {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        approvals.setUpdatedAt(ts);

        Approvals updated = approvalsService.update(id, approvals);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Boolean check = approvalsService.delete(id);
        return ResponseEntity.ok(check);
    }
}
