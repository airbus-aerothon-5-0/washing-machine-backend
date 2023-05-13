package com.example.washingmachinebackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "assembly")
public class Assembly {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "machine_id", nullable = false, unique = true)
    private String machineId;

    private String processName;
    private Date in_date;
    private Date out_date;



    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany
    private List<SubAssembly> subAssemblyList;

}
