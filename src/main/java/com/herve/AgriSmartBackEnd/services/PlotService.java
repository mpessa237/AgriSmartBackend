package com.herve.AgriSmartBackEnd.services;

import com.herve.AgriSmartBackEnd.dtos.PlotRequest;
import com.herve.AgriSmartBackEnd.models.Event;
import com.herve.AgriSmartBackEnd.models.Plot;
import com.herve.AgriSmartBackEnd.repositories.EventRepo;
import com.herve.AgriSmartBackEnd.repositories.PlotRepo;
import com.herve.AgriSmartBackEnd.repositories.RegisterRepo;
import com.herve.AgriSmartBackEnd.users.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PlotService {

    private final PlotRepo plotRepo;
    private final RegisterRepo registerRepo;
    private final EventRepo eventRepo;

    @Transactional
    public Plot createPlot(PlotRequest plotRequest, User userConnected){
        if (!userConnected.getId().equals(plotRequest.getId())){
            throw new RuntimeException("You cannot create a plot for another user.");
        }

        User user = registerRepo.findById(plotRequest.getId())
                .orElseThrow(()-> new RuntimeException("user not found!!"));

        long numberPlots = plotRepo.countByUser(user);
        if (numberPlots >= 5){
            throw new RuntimeException("You have reached the maximum limit of 5 plots.");
        }

        Plot plot = new Plot();
        plot.setName(plotRequest.getName());
        plot.setArea(plotRequest.getArea());
        plot.setCropType(plotRequest.getCropType());
        plot.setSoilType(plotRequest.getCropType());
        plot.setUser(user);

        plot = plotRepo.save(plot);

        Event event = new Event();
        event.setDate(event.getDate());
        event.setType(event.getType());
        event.setDescription("Creation of the plot" +plot.getName());
        event.setPlot(plot);
        eventRepo.save(event);

        return plot;

    }
}
