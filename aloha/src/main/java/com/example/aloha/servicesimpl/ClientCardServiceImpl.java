package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public List<ClientCard> getClientCardByIdClient(Long idClient) {
        return clientCardRepository.findByIdClient(idClient);
    }

    @Override
    public void createClientCard(@RequestBody ClientCard clientCard) {
        clientCardRepository.save(clientCard);
    }

    @Override
    public void updateClientCard(@RequestBody ClientCard clientCard) {
        clientCardRepository.save(clientCard);
    }

    @Override
    public void deleteClientCard(Long id) {
        clientCardRepository.deleteById(id);
    }

    @Override
    public void deleteClientCardByIdCard(Long idCard) {
        clientCardRepository.deleteByIdCard(idCard);
    }

    @Override
    public void deleteClientCardByIdClient(Long idClient) {
        clientCardRepository.deleteByIdClient(idClient);
    }

}
