package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.Fabrication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FabricationRepo extends JpaRepository<Fabrication, Integer> {
    @Query(value = "SELECT * FROM fabricatiton WHERE id = :id", nativeQuery = true)
    Fabrication getFabricationByID(Integer id);

    @Query(value = "SELECT * FROM fabricatiton", nativeQuery = true)
    List<Fabrication> getAllFabrications();

    @Query(value = "SELECT * FROM fabricatiton WHERE item_id = :item_id", nativeQuery = true)
    Fabrication getFabricationByItemId(String item_id);
}
