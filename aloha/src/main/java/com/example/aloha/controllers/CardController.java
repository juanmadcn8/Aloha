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

import com.example.aloha.dtos.BooleanResponse;
import com.example.aloha.models.Card;
import com.example.aloha.services.CardService;
import com.example.aloha.services.ClientCardService;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ClientCardService clientCardService;

    @GetMapping()
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Optional<Card> getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @GetMapping("idUsuario/{id}")
    public List<Card> getCardByIdUsuario(@PathVariable Long id) {
        return cardService.getCardByIdUsuario(id);
    }

    @PostMapping("/create")
    public Long createCard(@RequestBody Card card) {
        cardService.createCard(card);
        return cardService.getCardIdByNumberExpirationCvvAndOwner(card);
    }

    @PutMapping("/update")
    public void updateCard(@RequestBody Card card) {
        cardService.updateCard(card);
    }

    @DeleteMapping("/delete")
    public void deleteCard(@RequestBody Card card) {
        clientCardService.deleteClientCardByIdCard(card.getId());
        cardService.deleteCard(card.getId());
    }

    @PostMapping("/exist")
    public BooleanResponse existCard(@RequestBody Card card) {
        return cardService.existCard(card);
    }

}
