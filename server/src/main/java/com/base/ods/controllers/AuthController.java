package com.base.ods.controllers;

import com.base.ods.controllers.requests.RefreshRequest;
import com.base.ods.controllers.requests.UserRequest;
import com.base.ods.controllers.responses.AuthResponse;
import com.base.ods.services.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private IAuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshRequest refreshRequest) {
        return authService.refresh(refreshRequest);
    }
}
