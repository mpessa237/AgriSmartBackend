package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.models.Plot;
import com.herve.AgriSmartBackEnd.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepo extends JpaRepository<Plot,Integer> {

    long countByUser(User user);
    boolean existsByNameAndUser(String name, User user);
}
