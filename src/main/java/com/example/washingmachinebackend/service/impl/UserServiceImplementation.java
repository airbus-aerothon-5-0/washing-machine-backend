package com.example.washingmachinebackend.service.impl;


import com.example.washingmachinebackend.entity.Role;
import com.example.washingmachinebackend.entity.User;
import com.example.washingmachinebackend.payload.UserRequest;
import com.example.washingmachinebackend.repository.RoleRepo;
import com.example.washingmachinebackend.repository.UserRepo;
import com.example.washingmachinebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public void createUser(UserRequest userRequest) {

        User user = mapUserRequestToUser(userRequest);
        userRepo.save(user);
    }

    public User mapUserRequestToUser(UserRequest userRequest){
        User user = new User();

        user.setPassword(this.passwordEncoder.encode(userRequest.getPassword()));

        user.setUsername(userRequest.getUsername());

        user.setName(userRequest.getName());

        Set<Role> roleSet = new HashSet<>();

        for (String roleName : userRequest.getRole_names()) {
            Role role = roleRepo.findByName(roleName);
            if (role != null) {
                roleSet.add(role);
            }
        }
        user.setRoles(roleSet);

        return user;
    }

}
