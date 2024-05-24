package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.aloha.models.ClientCard;

@Repository
public interface ClientCardService {

    public List<ClientCard> getAllClientCards();

    public Optional<ClientCard> getClientCardById(Long id);

    public Optional<ClientCard> getClientCardByIdClient(Long idClient);

    public void createClientCard(ClientCard clientCard);

    public void updateClientCard(ClientCard clientCard);

    public void deleteClientCard(Long id);
}
