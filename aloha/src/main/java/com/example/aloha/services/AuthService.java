package com.example.aloha.services;

import com.example.aloha.models.AuthResponse;
import com.example.aloha.models.AuthenticationRequest;
import com.example.aloha.models.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticationRequest request);
}
