package com.herve.AgriSmartBackEnd.mappers;

import com.herve.AgriSmartBackEnd.dtos.AlertRequest;
import com.herve.AgriSmartBackEnd.dtos.AlertResponse;
import com.herve.AgriSmartBackEnd.models.Alert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertMapper {

    public Alert toEntity(AlertRequest alertRequest){
        Alert alert = new Alert();

        alert.setAlertType(alertRequest.getAlertType());
        alert.setAlertSeverity(alertRequest.getAlertSeverity());
        alert.setMessage(alertRequest.getMessage());

        return alert;
    }

    public AlertResponse toDto(Alert alert){

        AlertResponse alertResponse = new AlertResponse();
        alertResponse.setAlertType(alert.getAlertType());
        alertResponse.setAlertSeverity(alert.getAlertSeverity());
        alertResponse.setMessage(alert.getMessage());
        alertResponse.setDateAlert(alert.getDateAlert());

        alertResponse.setId(alert.getId());

        alertResponse.setUserId(alert.getUser().getId());
        alertResponse.setName(alert.getUser().getName());
        return alertResponse;

    }
}
