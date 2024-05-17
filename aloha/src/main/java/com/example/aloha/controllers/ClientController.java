package com.example.aloha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.dtos.ClientDTO;
import com.example.aloha.models.Client;
import com.example.aloha.models.User;
import com.example.aloha.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/create")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @PutMapping("/{id}/update")
    public void updateClient(@PathVariable Long id, @RequestBody ClientDTO client) {

        Optional<Client> fidedClient = clientService.getClientById(id);

        fidedClient.ifPresent(c -> {
            c.setEmail(client.getEmail());
            c.setName(client.getName());
            c.setSurname(client.getSurname());
            c.setPhone(client.getPhone());
            clientService.updateClient(c);
        });

    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody Client client) {
        clientService.deleteClient(client.getId());
    }

}
