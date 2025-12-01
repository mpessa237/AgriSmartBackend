package com.herve.AgriSmartBackEnd.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotRequest {
    @NotEmpty(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    private String name;
    private Double area;
    @NotEmpty(message = "SoilType is mandatory")
    @NotBlank(message = "SoilType is mandatory")
    private String soilType;
    @NotEmpty(message = "CropType is mandatory")
    @NotBlank(message = "CropType is mandatory")
    private String cropType;

    @NotEmpty(message = "Id is mandatory")
    @NotBlank(message = "Id is mandatory")
    private Integer id;
}
