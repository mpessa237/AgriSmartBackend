package com.herve.AgriSmartBackEnd.dtos;

import com.herve.AgriSmartBackEnd.models.AlertSeverity;
import com.herve.AgriSmartBackEnd.models.AlertType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertResponse {
    private Integer id;
    private AlertType alertType;
    private AlertSeverity alertSeverity;
    private String message;
    private LocalDateTime dateAlert;

    private Integer userId;
    private String name;
}
