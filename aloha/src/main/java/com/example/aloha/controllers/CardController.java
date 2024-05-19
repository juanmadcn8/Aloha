package com.example.aloha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.models.Card;
import com.example.aloha.services.CardService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping()
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Optional<Card> getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping("/create")
    public void createCard(@RequestBody Card card) {
        cardService.createCard(card);
    }

    @PutMapping("/update")
    public void updateCard(@RequestBody Card card) {
        cardService.updateCard(card);
    }

    @DeleteMapping("/delete")
    public void deleteCard(@RequestBody Card card) {
        cardService.deleteCard(card.getId());
    }

}
