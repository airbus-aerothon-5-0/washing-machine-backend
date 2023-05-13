package com.example.washingmachinebackend.service.impl;

import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.entity.SubAssembly;
import com.example.washingmachinebackend.payload.SubAssemblyDao;
import com.example.washingmachinebackend.repository.FabricationRepo;
import com.example.washingmachinebackend.repository.SubAssemblyRepo;
import com.example.washingmachinebackend.service.SubAssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubAssemblyServiceImplementation implements SubAssemblyService {

    @Autowired
    private SubAssemblyRepo subAssemblyRepo;

    @Autowired
    private FabricationRepo fabricationRepo;

    @Override
    public void createSubAssembly(SubAssemblyDao subAssemblyDao) {
        SubAssembly subAssembly = new SubAssembly();
        subAssembly.setIn_date(subAssemblyDao.getIn_date());
        subAssembly.setOut_date(subAssemblyDao.getOut_date());
        subAssembly.setMachineId(subAssemblyDao.getMachineId());
        subAssembly.setProcessName(subAssemblyDao.getProcessName());


        List<Fabrication> fabricationList = new ArrayList<>();
        for (String id: subAssemblyDao.getFabrication_item_ids()) {

            fabricationList.add(fabricationRepo.getFabricationByItemId(id));
        }
        subAssembly.setFabrication(fabricationList);
        subAssembly.setAssemblyId("default");
        SubAssembly updatedSub =  subAssemblyRepo.save(subAssembly);

        updatedSub.setAssemblyId("SAWM"+updatedSub.getId());
        subAssemblyRepo.save(updatedSub);

    }

    @Override
    public void updateSubAssembly(SubAssemblyDao subAssemblyDao) {

    }

    @Override
    public List<SubAssembly> getAllSubAssembly() {


        return subAssemblyRepo.findAllSubAssembly();
    }

    @Override
    public List<Fabrication> getAllFabricationBySubAssemblyId(String assemblyId) {

        SubAssembly subAssembly = subAssemblyRepo.findAllSubAssemblyByAssemblyId(assemblyId);
        return subAssembly.getFabrication();
    }
}
