package com.example.washingmachinebackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sub_assembly")
public class SubAssembly {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "assembly_id", nullable = false, unique = true)
    private String assemblyId;

    private String machineId;
    private String processName;
    private Date in_date;
    private Date out_date;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.EAGER)
    private List<Fabrication> fabrication;

}
