package com.example.washingmachinebackend.repository;

import com.example.washingmachinebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user_table WHERE username = :username", nativeQuery = true)
    User findByUsername(String username);
}
