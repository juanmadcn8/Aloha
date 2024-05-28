package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.AccommodationUnitService;

import jakarta.transaction.Transactional;

@Repository
public interface AccommodationUnitServiceRepository extends JpaRepository<AccommodationUnitService, Long> {
    @Query(value = "SELECT * FROM accommodation_unit_service WHERE accommodation_unit_id = :id", nativeQuery = true)
    List<AccommodationUnitService> findByAccommodationUnitId(Long id);

    @Query(value = "SELECT * FROM accommodation_unit_service", nativeQuery = true)
    List<AccommodationUnitService> findByNameService(String nameService);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM accommodation_unit_service WHERE accommodation_unit_id = :id", nativeQuery = true)
    void deleteByAccommodationUnitId(Long id);
}
