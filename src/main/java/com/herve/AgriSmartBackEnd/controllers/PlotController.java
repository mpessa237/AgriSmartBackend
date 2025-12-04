package com.herve.AgriSmartBackEnd.controllers;

import com.herve.AgriSmartBackEnd.dtos.PlotRequest;
import com.herve.AgriSmartBackEnd.dtos.PlotResponse;
import com.herve.AgriSmartBackEnd.mappers.PlotMapper;
import com.herve.AgriSmartBackEnd.models.Plot;
import com.herve.AgriSmartBackEnd.services.PlotService;
import com.herve.AgriSmartBackEnd.users.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plots")
public class PlotController {

    private final PlotService plotService;
    private final PlotMapper plotMapper;

    @PostMapping
    public ResponseEntity<PlotResponse> save(@Valid @RequestBody PlotRequest plotRequest,
                                             @RequestHeader("X-User-ID") Integer id){
        Plot plot = plotService.createPlot(plotRequest,id);
        PlotResponse plotResponse = plotMapper.toDto(plot);
        return ResponseEntity.ok(plotResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlotResponse> getPlotById(@PathVariable Integer id){
        return ResponseEntity.ok(this.plotService.getPlotById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlotResponse>> getAllPlots(@RequestHeader("X-User-ID") Integer id){
        List<Plot> plots = plotService.getAllPlotsByUser(id);
        List<PlotResponse> responses = plots.stream()
                .map(plotMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlotResponse> update(@PathVariable Integer id,
                                               @Valid @RequestBody PlotRequest plotRequest){
        Plot plot = plotService.updatePlot(id, plotRequest);
        PlotResponse response = plotMapper.toDto(plot);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/type/{cropType}")
    public ResponseEntity<List<PlotResponse>> getPlotByCropType(
            @PathVariable String cropType,
            @RequestHeader("X-User-ID") Integer id
    ){
        List<Plot> plots = plotService.getPlotsByCropType(id, cropType);
        List<PlotResponse> responses = plots.stream()
                .map(plotMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
