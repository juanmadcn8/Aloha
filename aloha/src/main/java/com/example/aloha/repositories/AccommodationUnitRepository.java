package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.dtos.ViewAccommodationUnit;
import com.example.aloha.models.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long> {

    // @Query(value = "SELECT * FROM accommodation_unit a INNER JOIN
    // category_accommodation_unit c ON a.id=c.accommodation_unit_id", nativeQuery =
    // true)
    @Query(value = "SELECT * FROM accommodation_unit", nativeQuery = true)
    List<AccommodationUnit> getAll();

}
