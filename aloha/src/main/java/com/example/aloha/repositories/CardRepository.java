package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aloha.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
