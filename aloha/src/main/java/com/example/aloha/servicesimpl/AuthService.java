package com.example.aloha.servicesimpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aloha.auth.AuthResponse;
import com.example.aloha.auth.LoginRequest;
import com.example.aloha.auth.RegisterRequest;
import com.example.aloha.enums.Role;
import com.example.aloha.models.Client;
import com.example.aloha.repositories.ClientRepository;
import com.example.aloha.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final ClientRepository clientRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                UserDetails client = clientRepository.findByEmail(request.getEmail()).orElseThrow();
                String token = jwtService.getToken(client);
                return AuthResponse.builder()
                                .token(token)
                                .build();

        }

        public AuthResponse registerClient(RegisterRequest request) {
                Client client = Client.builder()
                                .name(request.getName())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .surname(request.getSurname())
                                .email(request.getEmail())
                                .role(Role.CLIENT)
                                .build();

                clientRepository.save(client);
                return AuthResponse.builder()
                                .token(jwtService.getToken(client))
                                .build();

        }

}