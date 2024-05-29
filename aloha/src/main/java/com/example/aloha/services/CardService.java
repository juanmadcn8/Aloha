package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.dtos.BooleanResponse;
import com.example.aloha.models.Card;

public interface CardService {
    public List<Card> getAllCards();

    public Optional<Card> getCardById(Long id);

    public Card getCardByNumber(String number);

    public Long getCardIdByNumberExpirationCvvAndOwner(Card card);

    public Card createCard(Card card);

    public void updateCard(Card card);

    public void deleteCard(Long id);

    public BooleanResponse existCard(Card card);

    public List<Card> getCardByIdUsuario(Long id);
}
