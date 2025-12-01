package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer> {
}
