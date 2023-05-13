package com.example.washingmachinebackend.service;

import com.example.washingmachinebackend.entity.Assembly;
import com.example.washingmachinebackend.entity.Fabrication;
import com.example.washingmachinebackend.entity.SubAssembly;
import com.example.washingmachinebackend.payload.AssemblyDao;
import com.example.washingmachinebackend.payload.SubAssemblyDao;

import java.util.List;

public interface AssemblyService {

    void createAssembly(AssemblyDao assemblyDao);

    void  updateAssembly(AssemblyDao assemblyDao);

    List<Assembly> getAllAssembly();

    List<SubAssembly> getAllSubAssemblyBySubAssemblyId(int assemblyId);
}
