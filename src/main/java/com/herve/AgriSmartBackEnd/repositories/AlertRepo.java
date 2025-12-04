package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Alert;
import com.herve.AgriSmartBackEnd.models.AlertSeverity;
import com.herve.AgriSmartBackEnd.models.AlertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlertRepo extends JpaRepository<Alert,Integer> {

    // Trouver les alertes non expirées
   // List<Alert> findByExpirationDateAfter(LocalDateTime dateAlert);

    // Trouver les alertes par type
    //List<Alert> findByType(AlertType alertType);

    // Trouver les alertes par gravité
    //List<Alert> findBySeverity(AlertSeverity alertSeverity);
}
