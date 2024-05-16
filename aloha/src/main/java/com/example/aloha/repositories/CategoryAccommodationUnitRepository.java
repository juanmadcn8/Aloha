package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.CategoryAccommodationUnit;

@Repository
public interface CategoryAccommodationUnitRepository extends JpaRepository<CategoryAccommodationUnit, Long> {

    @Query(value = "SELECT accommodation_unit.name FROM category_accommodation_unit as cau INNER JOIN accommodation_unit as au ON au.id = cau.id_accommodation_unit INNER JOIN category as c ON c.id = cau.id_category", nativeQuery = true)
    List<CategoryAccommodationUnit> findByCategory(String category);

}
