package com.herve.AgriSmartBackEnd.controllers;

import com.herve.AgriSmartBackEnd.common.ApiResponse;
import com.herve.AgriSmartBackEnd.dtos.AuthenticationRequest;
import com.herve.AgriSmartBackEnd.dtos.AuthenticationResponse;
import com.herve.AgriSmartBackEnd.dtos.RegisterRequest;
import com.herve.AgriSmartBackEnd.services.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterRequest request)throws MessagingException {
        registerService.register(request);
        return ResponseEntity.ok(new ApiResponse("user register successfully!",request.getName()));
    }


}
