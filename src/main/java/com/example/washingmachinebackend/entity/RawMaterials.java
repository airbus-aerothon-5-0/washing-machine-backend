package com.example.washingmachinebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "raw_materials")
public class RawMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String raw_material_name;

    @Column(name = "item_name", nullable = false, unique = true)
    private String item_name;
    private double quantity_value;
    private String quantity_unit;


    @OneToMany(mappedBy = "rawMaterials",cascade = CascadeType.ALL)
    private List<Fabrication> fabricationList= new ArrayList<>();
}
