package com.example.washingmachinebackend.payload;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AssemblyDao {
    private Integer id;
    private String machineId;

    private String processName;
    private Date in_date;
    private Date out_date;

    private List<String> subAssembly_assemblyid;
}
