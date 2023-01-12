package com.base.ods.services;

import com.base.ods.controllers.requests.RefreshRequest;
import com.base.ods.controllers.requests.UserRequest;
import com.base.ods.controllers.responses.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthService {
    AuthResponse login(@RequestBody UserRequest loginRequest);

    ResponseEntity<AuthResponse> refresh(@RequestBody RefreshRequest refreshRequest);
}
