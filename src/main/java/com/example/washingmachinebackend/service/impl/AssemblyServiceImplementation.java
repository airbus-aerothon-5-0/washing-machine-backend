package com.example.washingmachinebackend.service.impl;

import com.example.washingmachinebackend.entity.Assembly;
import com.example.washingmachinebackend.entity.SubAssembly;
import com.example.washingmachinebackend.payload.AssemblyDao;
import com.example.washingmachinebackend.repository.AssemblyRepo;
import com.example.washingmachinebackend.repository.SubAssemblyRepo;
import com.example.washingmachinebackend.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssemblyServiceImplementation implements AssemblyService {

    @Autowired
    private AssemblyRepo assemblyRepo;

    @Autowired
    private SubAssemblyRepo subAssemblyRepo;

    @Override
    public void createAssembly(AssemblyDao assemblyDao) {

        Assembly assembly = new Assembly();
        assembly.setIn_date(assemblyDao.getIn_date());
        assembly.setOut_date(assemblyDao.getOut_date());
        assembly.setMachineId(assemblyDao.getMachineId());
        assembly.setProcessName(assemblyDao.getProcessName());

        List<SubAssembly> subAssemblyList= new ArrayList<>();
        for (String id: assemblyDao.getSubAssembly_assemblyid()) {
            subAssemblyList.add(subAssemblyRepo.findAllSubAssemblyByAssemblyId(id));
        }
        assembly.setSubAssemblyList(subAssemblyList);


        assemblyRepo.save(assembly);
    }

    @Override
    public void updateAssembly(AssemblyDao assemblyDao) {

    }

    @Override
    public List<Assembly> getAllAssembly() {
        return assemblyRepo.getAllAssembly();
    }

    @Override
    public List<SubAssembly> getAllSubAssemblyBySubAssemblyId(int assemblyId) {

        Assembly assembly = assemblyRepo.getAssemblyById(assemblyId);
        return assembly.getSubAssemblyList();
    }
}
