package com.example.washingmachinebackend.service;

import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.entity.SubAssembly;
import com.example.washingmachinebackend.payload.FabricationDao;
import com.example.washingmachinebackend.payload.SubAssemblyDao;

import java.util.List;

public interface SubAssemblyService {

    void createSubAssembly(SubAssemblyDao subAssemblyDao);

    void  updateSubAssembly(SubAssemblyDao subAssemblyDao);

    List<SubAssembly> getAllSubAssembly();

    List<Fabrication> getAllFabricationBySubAssemblyId(String assemblyId);
}
