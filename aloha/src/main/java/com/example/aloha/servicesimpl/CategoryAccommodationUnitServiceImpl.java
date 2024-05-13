package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.CategoryAccommodationUnit;
import com.example.aloha.repositories.CategoryAccommodationUnitRepository;
import com.example.aloha.services.CategoryAccommodationUnitService;

@Service
public class CategoryAccommodationUnitServiceImpl implements CategoryAccommodationUnitService {

    @Autowired
    private CategoryAccommodationUnitRepository categoryAccommodationUnitRepository;

    @Override
    public void createCategoryAccommodationUnit(CategoryAccommodationUnit categoryAccommodationUnit) {
        categoryAccommodationUnitRepository.save(categoryAccommodationUnit);
    }

    @Override
    public void updateCategoryAccommodationUnit(CategoryAccommodationUnit categoryAccommodationUnit) {
        categoryAccommodationUnitRepository.save(categoryAccommodationUnit);
    }

    @Override
    public void deleteCategoryAccommodationUnitById(Long id) {
        categoryAccommodationUnitRepository.deleteById(id);
    }

    @Override
    public List<CategoryAccommodationUnit> getCategoryAccommodationUnits() {
        return categoryAccommodationUnitRepository.findAll();
    }

    @Override
    public Optional<CategoryAccommodationUnit> getCategoryAccommodationUnitById(Long id) {
        return categoryAccommodationUnitRepository.findById(id);
    }

    @Override
    public List<CategoryAccommodationUnit> getCategoryAccommodationUnitsByCategory(String category) {
        return categoryAccommodationUnitRepository.findByCategoryName(category);
    }

}
