package com.example.washingmachinebackend.controller;


import com.example.washingmachinebackend.config.JwtTokenHelper;
import com.example.washingmachinebackend.payload.JwtAuthRequest;
import com.example.washingmachinebackend.payload.JwtAuthResponse;
import com.example.washingmachinebackend.payload.UserRequest;
import com.example.washingmachinebackend.repository.RoleRepo;
import com.example.washingmachinebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/auth/")
public class UserController {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request
    ) throws Exception {
        System.out.println(request);
        try{
            this.authenticate(request.getUsername(), request.getPassword());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
        }
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(request.getUsername());


        String token = this.jwtTokenHelper.generateToken(userDetails);

        // Get the authorities from UserDetails
        List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());

        // Create a list to store the role names
        List<String> roleNames = new ArrayList<>();

        // Iterate over the authorities
        for (GrantedAuthority authority : authorities) {
            if (authority instanceof SimpleGrantedAuthority) {
                // Extract the role name from SimpleGrantedAuthority and add it to the list
                String roleName = authority.getAuthority();
                roleNames.add(roleName);
            }
        }

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        response.setRole_name(roleNames);




        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    private void authenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        System.out.println(authenticationToken);
        try{
            this.authenticationManager.authenticate(authenticationToken);

        }catch (BadCredentialsException e){
            throw  new Exception("Invalid Credentials");
        }catch (Exception e){
            System.out.println("Exception in authentication");
        }

    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest){
        System.out.println(userRequest);
        try{

            this.userService.createUser(userRequest);
        }catch(Exception e){
            return  new ResponseEntity<>("User Can't be Created",HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User Created Successfully",HttpStatus.CREATED);
    }
}
