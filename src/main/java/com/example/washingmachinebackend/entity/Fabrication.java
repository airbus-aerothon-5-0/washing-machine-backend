package com.example.washingmachinebackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "fabricatiton")
public class Fabrication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "item_id", nullable = false, unique = true)
    private String item_id;

    private Date in_date;
    private Date out_date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private  RawMaterials rawMaterials;

}
