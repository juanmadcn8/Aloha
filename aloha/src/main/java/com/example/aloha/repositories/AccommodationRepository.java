package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
