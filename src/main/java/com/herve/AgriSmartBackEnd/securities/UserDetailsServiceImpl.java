package com.herve.AgriSmartBackEnd.securities;

import com.herve.AgriSmartBackEnd.repositories.RegisterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RegisterRepo registerRepo;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return this.registerRepo.findByEmail(userEmail)
                .orElseThrow(()-> new RuntimeException("user not found!!"));
    }
}
