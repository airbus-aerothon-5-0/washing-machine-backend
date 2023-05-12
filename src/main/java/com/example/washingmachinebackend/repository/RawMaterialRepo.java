package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.RawMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RawMaterialRepo extends JpaRepository<RawMaterials, Integer> {

    @Query(value = "SELECT * FROM raw_materials WHERE id = :id", nativeQuery = true)
    RawMaterials findByRawMaterialId(Integer id);

    @Query(value = "SELECT * FROM raw_materials", nativeQuery = true)
    List<RawMaterials> findAllRawMaterial();
}
