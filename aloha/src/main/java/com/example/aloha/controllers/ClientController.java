package com.example.aloha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.auth.AuthResponse;
import com.example.aloha.auth.LoginClientRequest;
import com.example.aloha.dtos.ClientDTO;
import com.example.aloha.models.Client;
import com.example.aloha.services.BookingService;
import com.example.aloha.services.ClientCardService;
import com.example.aloha.services.ClientService;
import com.example.aloha.servicesimpl.AuthService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AuthService authService;

    @Autowired
    private ClientCardService clientCardService;

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
    public ResponseEntity<AuthResponse> updateClient(@PathVariable Long id, @RequestBody ClientDTO client) {

        Optional<Client> findedClient = clientService.getClientById(id);
        LoginClientRequest request = new LoginClientRequest();

        findedClient.ifPresent(c -> {
            c.setEmail(client.getEmail());
            c.setName(client.getName());
            c.setSurname(client.getSurname());
            c.setPhone(client.getPhone());
            clientService.updateClient(c);
        });

        findedClient = clientService.getClientById(id);

        request.setEmail(findedClient.get().getEmail());
        request.setPassword(client.getPassword());

        return ResponseEntity.ok(authService.loginClient(request));
    }

    @DeleteMapping("/{id}/delete")
    public void deleteClient(@PathVariable Long id) {
        clientCardService.deleteClientCardByIdClient(id);
        bookingService.deleteBookingByIdClient(id);
        clientService.deleteClient(id);
    }

}
