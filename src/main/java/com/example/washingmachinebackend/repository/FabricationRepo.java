package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.Fabrication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricationRepo extends JpaRepository<Fabrication,String> {
}
