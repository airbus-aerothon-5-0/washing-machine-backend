package com.example.washingmachinebackend.payload;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private Integer id;
    private  String name;
    private String username;
    private String password;
    private List<String> role_names;
}
