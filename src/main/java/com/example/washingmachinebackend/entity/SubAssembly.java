package com.example.washingmachinebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "sub_assembly")
public class SubAssembly {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Id
    @Column(name = "assembly_id", nullable = false, unique = true)
    private String assemblyId;

    private String machineId;
    private String processName;
    private Date in_date;
    private Date out_date;

}
