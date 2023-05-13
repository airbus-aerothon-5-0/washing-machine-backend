package com.example.washingmachinebackend.controller;


import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.payload.FabricationDao;
import com.example.washingmachinebackend.service.FabricationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fabrication/")
public class FabricationController {

    @Autowired
    private FabricationService fabricationService;

    @GetMapping("/getFabrication")
    public ResponseEntity<?> getFabrication() {
        List<Fabrication> fabricationDaoList = fabricationService.getAllFabrication();
         return new ResponseEntity<>(fabricationDaoList, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('fabrication')")
    @PostMapping("/createFabrication")
    public ResponseEntity<?> createFabrication(@RequestBody FabricationDao fabricationDao) {
        try {
            this.fabricationService.createFabrication(fabricationDao);
            System.out.println("Fabrication created successfully");
            return new ResponseEntity<>("Fabrication Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Fabrication creation Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAuthority('fabrication')")
    @PostMapping("/updateFabrication")
    public ResponseEntity<?> updateFabrication(@RequestBody FabricationDao fabricationDao) {
        try {
            this.fabricationService.updateFabrication(fabricationDao);
            System.out.println("Fabrication updated successfully");
            return new ResponseEntity<>("Fabrication Updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Fabrication Update Failed",HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAuthority('fabrication')")
    @DeleteMapping("/deleteFabrication/{fabricationId}")
    public ResponseEntity<?> deleteFabrication(@PathVariable int fabricationId) {
        try {
            this.fabricationService.deleteFabrication(fabricationId);
            System.out.println("Fabrication deleted successfully");
            return new ResponseEntity<>("Fabrication Deleted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Fabrication Deletion Failed",HttpStatus.BAD_REQUEST);
        }
    }

}
