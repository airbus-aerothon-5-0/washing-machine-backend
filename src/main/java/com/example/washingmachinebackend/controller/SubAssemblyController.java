package com.example.washingmachinebackend.controller;


import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.payload.SubAssemblyDao;
import com.example.washingmachinebackend.service.SubAssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subAssembly/")
public class SubAssemblyController {

    @Autowired
    private SubAssemblyService subAssemblyService;

    @GetMapping("/getSubAssembly")
    public ResponseEntity<?> getSubAssebmly() {

        return new ResponseEntity<>(subAssemblyService.getAllSubAssembly(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('sub-assembly')")
    @PostMapping("/create")
    public ResponseEntity<?> createFabrication(@RequestBody SubAssemblyDao subAssemblyDao) {
        try {
            this.subAssemblyService.createSubAssembly(subAssemblyDao);
            System.out.println("SubAssembly created successfully");
            return new ResponseEntity<>("SubAssembly Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("SubAssembly creation Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getFabricationList/{assembly_id}")
    public ResponseEntity<?> getSubAssebmly(@PathVariable String assembly_id) {
        System.out.println(assembly_id);

        return new ResponseEntity<>(subAssemblyService.getAllFabricationBySubAssemblyId(assembly_id), HttpStatus.OK);
    }
}
