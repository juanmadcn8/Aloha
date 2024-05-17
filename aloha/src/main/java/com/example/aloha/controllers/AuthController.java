package com.example.aloha.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.auth.AuthResponse;
import com.example.aloha.auth.LoginAdminRequest;
import com.example.aloha.auth.LoginClientRequest;
import com.example.aloha.auth.RegisterAdminRequest;
import com.example.aloha.auth.RegisterClientRequest;
import com.example.aloha.servicesimpl.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "loginClient")
    public ResponseEntity<AuthResponse> loginC(@RequestBody LoginClientRequest request) {
        return ResponseEntity.ok(authService.loginClient(request));
    }

    @PostMapping(value = "registerClient")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterClientRequest request) {
        return ResponseEntity.ok(authService.registerClient(request));
    }

    @PostMapping(value = "loginAdmin")
    public ResponseEntity<AuthResponse> loginAdmin(@RequestBody LoginAdminRequest request) {
        return ResponseEntity.ok(authService.loginAdmin(request));
    }

    @PostMapping(value = "registerAdmin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterAdminRequest request) {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginClientRequest request) {
        return ResponseEntity.ok(authService.loginClient(request));
    }

}
