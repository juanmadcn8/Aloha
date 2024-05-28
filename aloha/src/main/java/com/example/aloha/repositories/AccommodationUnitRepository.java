package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.aloha.models.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long> {

    @Query(value = "SELECT * FROM accommodation_unit", nativeQuery = true)
    List<AccommodationUnit> getAll();

    @Query(value = "SELECT * FROM accommodation_unit WHERE price <= :price", nativeQuery = true)
    List<AccommodationUnit> getAccommodationUnitsByMaxPrice(Double price);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM accommodation_unit WHERE accommodation_id = :id", nativeQuery = true)
    void deleteAccommodationUnitByIdAccommodation(Long id);

}
