package com.herve.AgriSmartBackEnd.repositories;

import com.herve.AgriSmartBackEnd.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
