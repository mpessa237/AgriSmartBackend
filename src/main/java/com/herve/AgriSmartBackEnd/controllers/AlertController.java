package com.herve.AgriSmartBackEnd.controllers;

import com.herve.AgriSmartBackEnd.dtos.AlertRequest;
import com.herve.AgriSmartBackEnd.dtos.AlertResponse;
import com.herve.AgriSmartBackEnd.mappers.AlertMapper;
import com.herve.AgriSmartBackEnd.models.Alert;
import com.herve.AgriSmartBackEnd.services.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;
    private final AlertMapper alertMapper;

    @PostMapping
    public ResponseEntity<AlertResponse> create(@Valid @RequestBody AlertRequest alertRequest){

        Alert alert = alertService.createAlert(alertRequest);
        AlertResponse response = alertMapper.toDto(alert);
        return ResponseEntity.ok(response);
    }
}
