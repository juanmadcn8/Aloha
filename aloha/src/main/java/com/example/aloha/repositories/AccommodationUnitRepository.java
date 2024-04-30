package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.AccommodationUnit;

@Repository
public interface AccommodationUnitRepository extends JpaRepository<AccommodationUnit, Long> {

}
