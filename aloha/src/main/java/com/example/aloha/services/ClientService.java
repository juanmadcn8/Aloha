package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.dtos.ClientDTO;
import com.example.aloha.models.Client;

public interface ClientService {
    public List<Client> getAllClients();

    public Optional<Client> getClientById(Long id);

    public Optional<Client> getClientByEmail(String email);

    public void createClient(Client client);

    public void updateClient(Client client);

    public void deleteClient(Long id);
}
