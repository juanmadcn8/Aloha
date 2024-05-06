package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.Card;

public interface CardService {
    public List<Card> getAllCards();

    public Optional<Card> getCardById(Long id);

    public void createCard(Card card);

    public void updateCard(Card card);

    public void deleteCard(Long id);
}