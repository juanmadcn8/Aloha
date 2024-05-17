package com.example.aloha.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client WHERE email = :email", nativeQuery = true)
    Optional<Client> findByEmail(String email);
}
