package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aloha.models.ClientCard;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

}
