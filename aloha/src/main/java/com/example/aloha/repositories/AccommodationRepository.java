package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aloha.models.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
