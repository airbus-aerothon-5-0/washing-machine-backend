package com.example.washingmachinebackend.service;

import com.example.washingmachinebackend.payload.RawMaterialDao;

import java.util.List;

public interface FabricationService {

    void createFabrication(RawMaterialDao rawMaterialDao);

    void  updateFabrication(RawMaterialDao rawMaterialDao);

    List<RawMaterialDao> getAllFabrication();

    void deleteFabrication(int raw_material_id);
}
