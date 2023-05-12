package com.example.washingmachinebackend.payload;

import lombok.Data;
import java.util.List;

@Data
public class JwtAuthResponse {
    private  String token;
    private List<String> role_name;
}