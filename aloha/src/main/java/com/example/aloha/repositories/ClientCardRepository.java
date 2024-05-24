package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.ClientCard;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

}
