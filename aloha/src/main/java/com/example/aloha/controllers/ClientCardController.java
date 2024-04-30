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

import com.example.aloha.models.ClientCard;
import com.example.aloha.services.ClientCardService;

@RestController
@RequestMapping("/api/clientcard")
public class ClientCardController {

    @Autowired
    private ClientCardService clientCardService;

    @GetMapping()
    public List<ClientCard> getAllClientCards() {
        return clientCardService.getAllClientCards();
    }

    @GetMapping("/{id}")
    public Optional<ClientCard> getClientCardById(@PathVariable Long id) {
        return clientCardService.getClientCardById(id);
    }

    @PostMapping("/create")
    public void createClientCard(@RequestBody ClientCard clientCard) {
        clientCardService.createClientCard(clientCard);
    }

    @PutMapping("/update")
    public void updateClientCard(@RequestBody ClientCard clientCard) {
        clientCardService.updateClientCard(clientCard);
    }

    @DeleteMapping("/delete")
    public void deleteClientCard(@RequestBody ClientCard clientCard) {
        clientCardService.deleteClientCard(clientCard.getId());
    }

}
