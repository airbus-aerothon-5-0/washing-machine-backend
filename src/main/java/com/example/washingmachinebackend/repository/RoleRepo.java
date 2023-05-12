package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    @Query(value = "SELECT * FROM role  WHERE name = :roleName", nativeQuery = true)
    Role findByName(String roleName);

}
