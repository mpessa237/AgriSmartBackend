package com.herve.AgriSmartBackEnd.services;

import com.herve.AgriSmartBackEnd.dtos.AlertRequest;
import com.herve.AgriSmartBackEnd.mappers.AlertMapper;
import com.herve.AgriSmartBackEnd.models.Alert;
import com.herve.AgriSmartBackEnd.models.UserAlert;
import com.herve.AgriSmartBackEnd.repositories.AlertRepo;
import com.herve.AgriSmartBackEnd.repositories.RegisterRepo;
import com.herve.AgriSmartBackEnd.repositories.UserAlertRepo;
import com.herve.AgriSmartBackEnd.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {
    private final AlertRepo alertRepo;
    private final RegisterRepo registerRepo;
    private final UserAlertRepo userAlertRepo;



    public Alert createAlert(AlertRequest alertRequest){

        Alert alert = new Alert();
        alert.setAlertType(alertRequest.getAlertType());
        alert.setAlertSeverity(alertRequest.getAlertSeverity());
        alert.setMessage(alertRequest.getMessage());
        alert.setDateAlert(LocalDateTime.now());
       // alert.setDateAlert(alertRequest.getDa);
        alert.setUser(alertRequest.getUser()); // Utilisateur qui crée l'alerte

        alert = alertRepo.save(alert);
        if (alert.getId() == null){
            throw new RuntimeException("Echec de la sauvegarde de l'alerte");
        }

        List<User> users = registerRepo.findAll();
        for (User user : users){
            UserAlert userAlert = new UserAlert(user,alert);
            userAlertRepo.save(userAlert);
        }

        return alert;
    }
}
