package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepo extends JpaRepository<Disease,Integer> {
}
