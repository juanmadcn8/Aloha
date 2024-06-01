package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aloha.models.ClientCard;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    @Query(value = "SELECT * FROM client_card WHERE client_id = :idClient", nativeQuery = true)
    public List<ClientCard> findByIdClient(Long idClient);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM client_card WHERE card_id = :idCard", nativeQuery = true)
    public void deleteByIdCard(Long idCard);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM client_card WHERE client_id = :idClient", nativeQuery = true)
    public void deleteByIdClient(Long idClient);

}
