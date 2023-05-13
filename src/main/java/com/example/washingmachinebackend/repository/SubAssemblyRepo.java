package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.SubAssembly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubAssemblyRepo extends JpaRepository<SubAssembly, Integer> {


    @Query(value = "SELECT * FROM sub_assembly", nativeQuery = true)
    List<SubAssembly> findAllSubAssembly();

    @Query(value = "SELECT * FROM sub_assembly WHERE assembly_id = :assembly_id", nativeQuery = true)
    SubAssembly findAllSubAssemblyByAssemblyId(String assembly_id);
}
