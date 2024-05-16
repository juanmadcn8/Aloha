package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.aloha.models.CategoryAccommodationUnit;

public interface CategoryAccommodationUnitService {

    public void createCategoryAccommodationUnit(CategoryAccommodationUnit categoryAccommodationUnit);

    public void updateCategoryAccommodationUnit(CategoryAccommodationUnit categoryAccommodationUnit);

    public void deleteCategoryAccommodationUnitById(Long id);

    public List<CategoryAccommodationUnit> getCategoryAccommodationUnits();

    public Optional<CategoryAccommodationUnit> getCategoryAccommodationUnitById(Long id);

    public List<CategoryAccommodationUnit> getCategoryAccommodationUnitsByCategory(String category);
}
