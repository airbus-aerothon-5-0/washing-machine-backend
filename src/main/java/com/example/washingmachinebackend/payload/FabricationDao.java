package com.example.washingmachinebackend.payload;


import lombok.Data;

import java.util.Date;

@Data
public class FabricationDao {

    private Integer id;
    private String item_id;

    private Date in_date;
    private Date out_date;

    private Integer raw_material_id;

}
