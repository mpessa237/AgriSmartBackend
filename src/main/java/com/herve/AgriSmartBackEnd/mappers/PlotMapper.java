package com.herve.AgriSmartBackEnd.mappers;

import com.herve.AgriSmartBackEnd.dtos.PlotRequest;
import com.herve.AgriSmartBackEnd.dtos.PlotResponse;
import com.herve.AgriSmartBackEnd.models.Plot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlotMapper {

    public Plot toEntity(PlotRequest plotRequest){

        Plot plot = new Plot();
        plot.setName(plotRequest.getName());
        plot.setArea(plotRequest.getArea());
        plot.setCropType(plotRequest.getCropType());
        plot.setSoilType(plotRequest.getSoilType());

        return plot;
    }

    public PlotResponse toDto(Plot plot){

        PlotResponse plotResponse = new PlotResponse();
        plotResponse.setId(plot.getId());
        plotResponse.setName(plot.getName());
        plotResponse.setArea(plot.getArea());
        plotResponse.setSoilType(plot.getSoilType());
        plotResponse.setCropType(plot.getCropType());

        return plotResponse;
    }
}
