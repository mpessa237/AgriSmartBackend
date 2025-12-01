package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepo extends JpaRepository<Alert,Integer> {
}
