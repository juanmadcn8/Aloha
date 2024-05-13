package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.CategoryAccommodationUnit;

@Repository
public interface CategoryAccommodationUnitRepository extends JpaRepository<CategoryAccommodationUnit, Long> {
    // @Query(value = "SELECT Accommodation_Unit.name, Accommodation_Unit.address,
    // Accommodation_Unit.Price_per_night FROM Accommodation_Unit INNER JOIN
    // Category ON ", nativeQuery = true)
    public List<CategoryAccommodationUnit> findByCategoryName(String categoryName);
}
