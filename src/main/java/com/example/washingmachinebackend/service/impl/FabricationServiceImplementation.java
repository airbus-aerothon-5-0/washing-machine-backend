package com.example.washingmachinebackend.service.impl;

import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.payload.FabricationDao;
import com.example.washingmachinebackend.payload.RawMaterialDao;
import com.example.washingmachinebackend.repository.FabricationRepo;
import com.example.washingmachinebackend.service.FabricationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricationServiceImplementation implements FabricationService {

    @Autowired
    private RawMaterialServiceImplementation rawMaterialServiceImplementation;

    @Autowired
    private FabricationRepo fabricationRepo;
    @Override
    public void createFabrication(FabricationDao fabricationDao) {
        Fabrication fabrication = new Fabrication();
        fabrication.setIn_date(fabricationDao.getIn_date());
        fabrication.setOut_date(fabricationDao.getOut_date());
        fabrication.setRawMaterials(rawMaterialServiceImplementation.getRawMaterial(fabricationDao.getRaw_material_id()));

        fabricationRepo.save(fabrication);
        updateFabrication(fabricationDao);
    }

    @Override
    public void updateFabrication(FabricationDao fabricationDao) {

        Fabrication fabrication = fabricationRepo.getFabricationByID(fabricationDao.getId());

        fabrication.setItem_id("T"+fabricationDao.getItem_id());
        fabrication.setOut_date(fabricationDao.getOut_date());
        fabrication.setIn_date(fabricationDao.getIn_date());
        fabrication.setRawMaterials(rawMaterialServiceImplementation.getRawMaterial(fabricationDao.getRaw_material_id()));

        fabricationRepo.save(fabrication);
    }

    @Override
    public List<Fabrication> getAllFabrication() {

        List<Fabrication> fabricationList= fabricationRepo.getAllFabrications();
        return fabricationList;
    }

    @Override
    public void deleteFabrication(int fabrication_id) {
        Fabrication fabrication = fabricationRepo.getFabricationByID(fabrication_id);

        fabricationRepo.delete(fabrication);
    }
}
