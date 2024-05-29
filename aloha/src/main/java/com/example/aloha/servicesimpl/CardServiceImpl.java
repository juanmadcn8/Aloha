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
    public Card createCard(Card card) {
        cardRepository.save(card);
        return card;
    }

    @Override
    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public Boolean existCard(Card card) {
        Card catchCard = cardRepository.findByNumber(card.getNumber());

        if (catchCard == null) {
            return false;
        } else {
            if (catchCard.getExpirationDate().equals(card.getExpirationDate())
                    && catchCard.getCvv().equals(card.getCvv())
                    && catchCard.getOwner().equals(card.getOwner())) {
                return true;
            } else {
                return false;

            }

        }
    }

    @Override
    public Card getCardByNumber(String number) {
        return cardRepository.findByNumber(number);
    }

    @Override
    public Long getCardIdByNumberExpirationCvvAndOwner(Card card) {
        Card catchCard = cardRepository.findByNumber(card.getNumber());

        if (catchCard == null) {
            return null;
        } else {
            if (catchCard.getExpirationDate().equals(card.getExpirationDate())
                    && catchCard.getCvv().equals(card.getCvv())
                    && catchCard.getOwner().equals(card.getOwner())) {
                return catchCard.getId();
            } else {
                return null;

            }

        }
    }

}
