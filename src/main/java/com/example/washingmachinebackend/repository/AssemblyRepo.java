package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.Assembly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssemblyRepo extends JpaRepository<Assembly,Integer> {
    @Query(value = "SELECT * FROM assembly", nativeQuery = true)
    List<Assembly> getAllAssembly();

    @Query(value = "SELECT * FROM assembly WHERE id = :assembly_id", nativeQuery = true)
    Assembly getAssemblyById(int assembly_id);
}
