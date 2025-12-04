package com.herve.AgriSmartBackEnd.services;

import com.herve.AgriSmartBackEnd.dtos.PlotRequest;
import com.herve.AgriSmartBackEnd.dtos.PlotResponse;
import com.herve.AgriSmartBackEnd.mappers.PlotMapper;
import com.herve.AgriSmartBackEnd.models.Event;
import com.herve.AgriSmartBackEnd.models.Plot;
import com.herve.AgriSmartBackEnd.repositories.EventRepo;
import com.herve.AgriSmartBackEnd.repositories.PlotRepo;
import com.herve.AgriSmartBackEnd.repositories.RegisterRepo;
import com.herve.AgriSmartBackEnd.users.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlotService {

    private final PlotRepo plotRepo;
    private final RegisterRepo registerRepo;
    private final EventRepo eventRepo;
    private final PlotMapper plotMapper;

    @Transactional
    public Plot createPlot(PlotRequest plotRequest, Integer id){


        User user = registerRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found!!"));

        long numberPlots = plotRepo.countByUser(user);
        if (numberPlots >= 5){
            throw new RuntimeException("You have reached the maximum limit of 5 plots.");
        }

        Plot plot = plotMapper.toEntity(plotRequest);
        plot.setUser(user);

        plot = plotRepo.save(plot);

        Event event = new Event();
        event.setDate(new Date());
        event.setType("CREATION");
        event.setDescription("Creation of the plot" +plot.getName());
        event.setPlot(plot);
        eventRepo.save(event);

        return plot;

    }

    public PlotResponse getPlotById(Integer id){
        Plot plot = plotRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("plot not found!!"));
        return this.plotMapper.toDto(plot);
    }

    public List<Plot> getAllPlotsByUser(Integer id){

        User user = registerRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found!!"));
        return plotRepo.findByUser(user);
    }


    public Plot updatePlot(Integer id,PlotRequest plotRequest){
        Plot plot = plotRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("plot not found!!"));
        plot.setName(plotRequest.getName());
        plot.setArea(plotRequest.getArea());
        plot.setSoilType(plotRequest.getSoilType());
        plot.setCropType(plotRequest.getCropType());

        return plotRepo.save(plot);
    }

    public List<Plot> getPlotsByCropType(Integer id,String cropType){
        User user = registerRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found!!"));
        return plotRepo.findByUserAndCropType(user,cropType);
    }


}
