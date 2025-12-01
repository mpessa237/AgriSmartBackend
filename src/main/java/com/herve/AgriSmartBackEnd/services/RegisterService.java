package com.herve.AgriSmartBackEnd.services;

import com.herve.AgriSmartBackEnd.dtos.RegisterRequest;
import com.herve.AgriSmartBackEnd.repositories.RegisterRepo;
import com.herve.AgriSmartBackEnd.users.Role;
import com.herve.AgriSmartBackEnd.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepo registerRepo;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setLocation(request.getLocation());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(Role.USER));
        user.setEnabled(false);
        user.setAccountLocked(false);



        registerRepo.save(user);
    }
}
