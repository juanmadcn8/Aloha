package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.CategoryAccommodationUnit;

@Repository
public interface CategoryAccommodationUnitRepository extends JpaRepository<CategoryAccommodationUnit, Long> {

}
