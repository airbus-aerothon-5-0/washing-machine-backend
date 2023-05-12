package com.example.washingmachinebackend.service;

import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.payload.FabricationDao;
import com.example.washingmachinebackend.payload.RawMaterialDao;

import java.util.List;

public interface FabricationService {

    void createFabrication(FabricationDao fabricationDao);

    void  updateFabrication(FabricationDao fabricationDao);

    List<Fabrication> getAllFabrication();

    void deleteFabrication(int fabrication_id);
}
