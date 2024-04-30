package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aloha.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
