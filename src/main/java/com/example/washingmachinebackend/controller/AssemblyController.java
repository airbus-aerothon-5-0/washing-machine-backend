package com.example.washingmachinebackend.controller;

import com.example.washingmachinebackend.payload.AssemblyDao;
import com.example.washingmachinebackend.payload.SubAssemblyDao;
import com.example.washingmachinebackend.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Assembly/")
public class AssemblyController {

    @Autowired
    private AssemblyService assemblyService;

    @GetMapping("/getAssembly")
    public ResponseEntity<?> getAssebmly() {

        return new ResponseEntity<>(assemblyService.getAllAssembly(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('assembly')")
    @PostMapping("/create")
    public ResponseEntity<?> createFabrication(@RequestBody AssemblyDao assemblyDao) {
        try {
            this.assemblyService.createAssembly(assemblyDao);
            System.out.println("Assembly created successfully");
            return new ResponseEntity<>("Assembly Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Assembly creation Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getSubAssemblyList/{assembly_id}")
    public ResponseEntity<?> getSubAssebmly(@PathVariable int assembly_id) {
        System.out.println(assembly_id);

        return new ResponseEntity<>(assemblyService.getAllSubAssemblyBySubAssemblyId(assembly_id), HttpStatus.OK);
    }
}
