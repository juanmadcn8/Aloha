package com.example.aloha.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.aloha.repositories.AdminRepository;
import com.example.aloha.repositories.ClientRepository;
import com.example.aloha.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final ClientRepository clientRepository;
    private final AdminRepository adminRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationClientProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(clientDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    // @Bean
    // public AuthenticationProvider authenticationAdminProvider() {
    // DaoAuthenticationProvider authenticationProvider = new
    // DaoAuthenticationProvider();
    // authenticationProvider.setUserDetailsService(adminDetailService());
    // authenticationProvider.setPasswordEncoder(passwordEncoder());
    // return authenticationProvider;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // @Qualifier("client")
    public UserDetailsService clientDetailService() {
        return email -> clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Client not found"));
    }

    // @Bean
    // @Qualifier("admin")
    // public UserDetailsService adminDetailService() {
    // return email -> adminRepository.findByEmail(email)
    // .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
    // }

}
