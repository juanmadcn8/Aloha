package com.example.aloha.servicesimpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aloha.auth.AuthResponse;
import com.example.aloha.auth.LoginAdminRequest;
import com.example.aloha.auth.LoginClientRequest;
import com.example.aloha.auth.RegisterAdminRequest;
import com.example.aloha.auth.RegisterClientRequest;
import com.example.aloha.enums.Role;
import com.example.aloha.models.Admin;
import com.example.aloha.models.Client;
import com.example.aloha.repositories.AdminRepository;
import com.example.aloha.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final ClientRepository clientRepository;
        private final AdminRepository adminRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse loginClient(LoginClientRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

                String token = null;

                if (clientRepository.findByEmail(request.getEmail()).isPresent()) {
                        UserDetails client = clientRepository.findByEmail(request.getEmail()).orElseThrow();
                        token = jwtService.getToken(client);
                } else {
                        UserDetails admin = adminRepository.findByEmail(request.getEmail()).orElseThrow();
                        token = jwtService.getToken(admin);
                }

                return AuthResponse.builder()
                                .token(token)
                                .build();

        }

        public AuthResponse loginAdmin(LoginAdminRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                UserDetails admin = adminRepository.findByEmail(request.getEmail()).orElseThrow();
                String token = jwtService.getToken(admin);
                return AuthResponse.builder()
                                .token(token)
                                .build();

        }

        public AuthResponse registerAdmin(RegisterAdminRequest request) {
                Admin admin = Admin.builder()
                                .name(request.getName())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .email(request.getEmail())
                                .role(Role.ADMIN)
                                .build();

                adminRepository.save(admin);
                return AuthResponse.builder()
                                .token(jwtService.getToken(admin))
                                .build();

        }

        public AuthResponse registerClient(RegisterClientRequest request) {

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
