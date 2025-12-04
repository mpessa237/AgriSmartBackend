package com.herve.AgriSmartBackEnd.dtos;

import com.herve.AgriSmartBackEnd.models.AlertSeverity;
import com.herve.AgriSmartBackEnd.models.AlertType;
import com.herve.AgriSmartBackEnd.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertRequest {

    private AlertType alertType;
    private AlertSeverity alertSeverity;
    private String message;

    private User user;
}
