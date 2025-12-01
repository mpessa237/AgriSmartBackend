package com.herve.AgriSmartBackEnd.controllers;

import com.herve.AgriSmartBackEnd.dtos.PlotRequest;
import com.herve.AgriSmartBackEnd.models.Plot;
import com.herve.AgriSmartBackEnd.services.PlotService;
import com.herve.AgriSmartBackEnd.users.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plots")
public class PlotController {

    private final PlotService plotService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PlotRequest plotRequest,
                                  @AuthenticationPrincipal User userConnected){
        Plot plot = plotService.createPlot(plotRequest,userConnected);
        return ResponseEntity.ok(plot);
    }
}
