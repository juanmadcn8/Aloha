package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.ClientCard;
import com.example.aloha.repositories.ClientCardRepository;
import com.example.aloha.services.ClientCardService;

@Service
public class ClientCardServiceImpl implements ClientCardService {

    @Autowired
    private ClientCardRepository clientCardRepository;

    @Override
    public List<ClientCard> getAllClientCards() {
        return clientCardRepository.findAll();
    }

    @Override
    public Optional<ClientCard> getClientCardById(Long id) {
        return clientCardRepository.findById(id);
    }

    @Override
    public void createClientCard(ClientCard clientCard) {
        clientCardRepository.save(clientCard);
    }

    @Override
    public void updateClientCard(ClientCard clientCard) {
        clientCardRepository.save(clientCard);
    }

    @Override
    public void deleteClientCard(Long id) {
        clientCardRepository.deleteById(id);
    }

}
