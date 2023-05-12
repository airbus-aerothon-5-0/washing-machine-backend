package com.example.washingmachinebackend.controller;

import com.example.washingmachinebackend.payload.RawMaterialDao;
import com.example.washingmachinebackend.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rawMaterials")
public class RawMaterialsController {

    @Autowired
    private RawMaterialService rawMaterialService;

    @GetMapping("/getRawMaterials")
    public ResponseEntity<List<RawMaterialDao>> getRawMaterials() {
       List<RawMaterialDao> rawMaterials = rawMaterialService.getAllRawMaterials();
       return new ResponseEntity<>(rawMaterials, HttpStatus.OK);
    }

    @PostMapping("/createRawMaterials")
    public ResponseEntity<?> createRawMaterials(RawMaterialDao rawMaterialDao) {
        try {
            this.rawMaterialService.createRawMaterial(rawMaterialDao);
            System.out.println("Raw Material created successfully");
             return new ResponseEntity<>("Raw Material Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Raw Material creation Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateRawMaterials")
    public ResponseEntity<?> updateRawMaterials(RawMaterialDao rawMaterialDao) {
        try {
            this.rawMaterialService.updateRawMaterial(rawMaterialDao);
            System.out.println("Raw Material updated successfully");
            return new ResponseEntity<>("Raw Material Updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Raw Material Update Failed",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteRawMaterials")
    public ResponseEntity<?> deleteRawMaterials(int rawMaterialId) {
        try {
            this.rawMaterialService.deleteRawMaterials(rawMaterialId);
            System.out.println("Raw Material deleted successfully");
            return new ResponseEntity<>("Raw Material Deleted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Raw Material Deletion Failed",HttpStatus.BAD_REQUEST);
        }
    }

}
