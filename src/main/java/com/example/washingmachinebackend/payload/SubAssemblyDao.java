package com.example.washingmachinebackend.payload;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SubAssemblyDao {
    private Integer id;
    private String assemblyId;
    private String machineId;
    private String processName;
    private Date in_date;
    private Date out_date;
    private List<String> fabrication_item_ids;
}
