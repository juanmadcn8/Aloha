package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Card;
import com.example.aloha.repositories.CardRepository;
import com.example.aloha.services.CardService;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    @Override
    public void createCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

}
