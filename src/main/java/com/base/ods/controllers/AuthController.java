package com.base.ods.controllers;

import com.base.ods.domain.RefreshToken;
import com.base.ods.domain.User;
import com.base.ods.requests.RefreshRequest;
import com.base.ods.requests.UserRequest;
import com.base.ods.responses.AuthResponse;
import com.base.ods.security.JwtTokenProvider;
import com.base.ods.services.IAuthService;
import com.base.ods.services.impl.RefreshTokenServiceImpl;
import com.base.ods.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
