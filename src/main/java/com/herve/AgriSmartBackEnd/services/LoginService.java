package com.herve.AgriSmartBackEnd.services;

import com.herve.AgriSmartBackEnd.dtos.AuthenticationRequest;
import com.herve.AgriSmartBackEnd.dtos.AuthenticationResponse;
import com.herve.AgriSmartBackEnd.securities.JwtService;
import com.herve.AgriSmartBackEnd.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );

            User user = (User) authentication.getPrincipal();

            String accessToken = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setAccessToken(accessToken);
            authenticationResponse.setRefreshToken(refreshToken);
            return authenticationResponse;
        }
        catch (BadCredentialsException e) {
            throw new BadCredentialsException("Email or Password is not correct", e);
        } catch (DisabledException e) {
            throw new DisabledException("Account disabled", e);
        } catch (Exception e) {
            throw new BadCredentialsException("Error authentication", e);
        }
    }
}
