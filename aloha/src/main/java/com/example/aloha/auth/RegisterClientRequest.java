package com.example.aloha.auth;

import com.example.aloha.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientRequest {
    String name;
    String surname;
    String email;
    String password;
    String phone;
    Role role;
}
