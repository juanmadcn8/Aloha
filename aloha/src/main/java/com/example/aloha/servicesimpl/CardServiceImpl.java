package com.example.aloha.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.dtos.BooleanResponse;
import com.example.aloha.models.Card;
import com.example.aloha.models.ClientCard;
import com.example.aloha.repositories.CardRepository;
import com.example.aloha.repositories.ClientCardRepository;
import com.example.aloha.services.CardService;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ClientCardRepository clientCardRepository;

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
    public BooleanResponse existCard(Card card) {
        Card catchCard = cardRepository.findByNumber(card.getNumber());

        if (catchCard == null) {
            return new BooleanResponse(false);
        } else {
            if (catchCard.getExpirationDate().equals(card.getExpirationDate())
                    && catchCard.getCvv().equals(card.getCvv())
                    && catchCard.getOwner().equals(card.getOwner())) {
                return new BooleanResponse(true);
            } else {
                return new BooleanResponse(false);

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

    @Override
    public List<Card> getCardByIdUsuario(Long id) {
        List<ClientCard> clientCard = clientCardRepository.findByIdClient(id);
        List<Card> cards = new ArrayList();

        for (int i = 0; i < clientCard.size(); i++) {
            cards.add(clientCard.get(i).getCard());

        }

        return cards;
    }

}
