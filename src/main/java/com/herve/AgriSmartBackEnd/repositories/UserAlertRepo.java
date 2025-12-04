package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Alert;
import com.herve.AgriSmartBackEnd.models.UserAlert;
import com.herve.AgriSmartBackEnd.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAlertRepo extends JpaRepository<UserAlert,Integer> {

    // Trouver les alertes non lues d'un utilisateur
    //List<UserAlert> findByUserAndIsReadFalse(User user);

    // Trouver une alerte spécifique pour un utilisateur
    //UserAlert findByUserAndAlert(User user, Alert alert);
}
