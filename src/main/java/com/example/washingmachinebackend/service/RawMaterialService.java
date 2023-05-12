package com.example.washingmachinebackend.service;

import com.example.washingmachinebackend.entity.RawMaterials;
import com.example.washingmachinebackend.payload.RawMaterialDao;

import java.util.List;

public interface RawMaterialService {

    void createRawMaterial(RawMaterialDao rawMaterialDao);

    void  updateRawMaterial(RawMaterialDao rawMaterialDao);

    List<RawMaterialDao> getAllRawMaterials();

    RawMaterials getRawMaterial(int id);

    void deleteRawMaterials(int raw_material_id);
}
