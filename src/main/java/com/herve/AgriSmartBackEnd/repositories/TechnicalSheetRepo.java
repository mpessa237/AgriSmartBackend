package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.TechnicalSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalSheetRepo extends JpaRepository<TechnicalSheet,Integer> {
}
