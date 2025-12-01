package com.herve.AgriSmartBackEnd.controllers;

import com.herve.AgriSmartBackEnd.common.ApiResponse;
import com.herve.AgriSmartBackEnd.dtos.AuthenticationRequest;
import com.herve.AgriSmartBackEnd.dtos.AuthenticationResponse;
import com.herve.AgriSmartBackEnd.services.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest authenticationRequest){

        AuthenticationResponse response = loginService.authenticate(authenticationRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
