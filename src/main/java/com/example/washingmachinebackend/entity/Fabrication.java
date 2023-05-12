package com.example.washingmachinebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "fabricatiton")
public class Fabrication {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Id
    private String item_id;

    private Date in_date;
    private Date out_date;

    @ManyToOne
    private  RawMaterials rawMaterials;

}
