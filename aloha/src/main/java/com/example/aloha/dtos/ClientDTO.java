package com.example.aloha.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
}
