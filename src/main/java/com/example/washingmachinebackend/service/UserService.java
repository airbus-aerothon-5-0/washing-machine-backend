package com.example.washingmachinebackend.service;


import com.example.washingmachinebackend.payload.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(UserRequest userRequest);
}
