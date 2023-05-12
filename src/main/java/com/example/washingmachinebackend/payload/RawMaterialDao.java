package com.example.washingmachinebackend.payload;

import lombok.Data;

@Data
public class RawMaterialDao {
    private Integer id;

    private String raw_material_name;
    private String item_name;
    private double quantity_value;
    private String quantity_unit;
}
