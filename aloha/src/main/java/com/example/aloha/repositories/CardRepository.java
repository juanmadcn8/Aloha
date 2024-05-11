package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
