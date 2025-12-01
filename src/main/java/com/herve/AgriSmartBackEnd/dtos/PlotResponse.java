package com.herve.AgriSmartBackEnd.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotResponse {
    private Integer id;
    private String name;
    private Double area;
    private String soilType;
    private String cropType;
}
