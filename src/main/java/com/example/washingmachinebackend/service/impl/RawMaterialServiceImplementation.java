package com.example.washingmachinebackend.service.impl;

import com.example.washingmachinebackend.entity.RawMaterials;
import com.example.washingmachinebackend.payload.RawMaterialDao;
import com.example.washingmachinebackend.repository.RawMaterialRepo;
import com.example.washingmachinebackend.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class RawMaterialServiceImplementation implements RawMaterialService {

    @Autowired
    private RawMaterialRepo rawMaterialRepo;

    @Override
    public void createRawMaterial(RawMaterialDao rawMaterialDao) {

        RawMaterials rawMaterials = new RawMaterials();
        rawMaterials.setRaw_material_name(rawMaterialDao.getRaw_material_name());
        rawMaterials.setItem_name(rawMaterialDao.getItem_name());
        rawMaterials.setQuantity_unit(rawMaterialDao.getQuantity_unit());
        rawMaterials.setQuantity_value(rawMaterialDao.getQuantity_value());

        rawMaterialRepo.save(rawMaterials);
    }

    @Override
    public void updateRawMaterial(RawMaterialDao rawMaterialDao) {

        RawMaterials rawMaterials = rawMaterialRepo.findByRawMaterialId(rawMaterialDao.getId());

        rawMaterials.setQuantity_unit(rawMaterialDao.getQuantity_unit());
        rawMaterials.setQuantity_value(rawMaterialDao.getQuantity_value());
        rawMaterials.setItem_name(rawMaterialDao.getItem_name());

        rawMaterialRepo.save(rawMaterials);


    }

    @Override
    public List<RawMaterialDao> getAllRawMaterials() {

        List<RawMaterials> rawMaterials = rawMaterialRepo.findAllRawMaterial();

        List<RawMaterialDao> rawMaterialDaoList = rawMaterials.stream()
                .map(rawMaterial -> {
                    RawMaterialDao rawMaterialDao = new RawMaterialDao();
                    rawMaterialDao.setRaw_material_name(rawMaterial.getRaw_material_name());
                    rawMaterialDao.setQuantity_unit(rawMaterial.getQuantity_unit());
                    rawMaterialDao.setQuantity_value(rawMaterial.getQuantity_value());
                    rawMaterialDao.setItem_name(rawMaterial.getItem_name());
                    return rawMaterialDao;
                })
                .collect(Collectors.toList());
        return rawMaterialDaoList;
    }

    @Override
    public RawMaterials getRawMaterial(int id) {
        return   rawMaterialRepo.findByRawMaterialId(id);
    }

    @Override
    public void deleteRawMaterials(int raw_material_id) {
        RawMaterials rawMaterials = rawMaterialRepo.findByRawMaterialId(raw_material_id);

        rawMaterialRepo.delete(rawMaterials);
    }
}
