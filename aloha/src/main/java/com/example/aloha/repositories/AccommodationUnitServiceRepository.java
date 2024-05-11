package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.AccommodationUnitService;

@Repository
public interface AccommodationUnitServiceRepository extends JpaRepository<AccommodationUnitService, Long> {

}
