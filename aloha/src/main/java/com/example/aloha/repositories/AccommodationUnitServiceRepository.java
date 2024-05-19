package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.AccommodationUnitService;

@Repository
public interface AccommodationUnitServiceRepository extends JpaRepository<AccommodationUnitService, Long> {
    @Query(value = "SELECT * FROM accommodation_unit_service WHERE accommodation_unit_id = :id", nativeQuery = true)
    List<AccommodationUnitService> findByAccommodationUnitId(Long id);
}
