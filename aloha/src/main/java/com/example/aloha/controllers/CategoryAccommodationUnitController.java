package com.example.aloha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.models.CategoryAccommodationUnit;
import com.example.aloha.services.CategoryAccommodationUnitService;

@RestController
@RequestMapping("/category-accommodation-unit")
public class CategoryAccommodationUnitController {

    @Autowired
    private CategoryAccommodationUnitService categoryAccommodationUnitService;

    @GetMapping()
    public List<CategoryAccommodationUnit> getCategoryAccommodationUnits() {
        return categoryAccommodationUnitService.getCategoryAccommodationUnits();
    }

    @GetMapping("/{category}")
    public List<CategoryAccommodationUnit> getCategoryAccommodationUnitsByCategory(@PathVariable String category) {
        return categoryAccommodationUnitService.getCategoryAccommodationUnitsByCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<CategoryAccommodationUnit> getCategoryAccommodationUnitById(@PathVariable Long id) {
        return categoryAccommodationUnitService.getCategoryAccommodationUnitById(id);
    }

    @PutMapping("/create")
    public void createCategoryAccommodationUnit(@RequestBody CategoryAccommodationUnit categoryAccommodationUnit) {
        categoryAccommodationUnitService.createCategoryAccommodationUnit(categoryAccommodationUnit);
    }

    @PostMapping("/update")
    public void updateCategoryAccommodationUnit(@RequestBody CategoryAccommodationUnit categoryAccommodationUnit) {
        categoryAccommodationUnitService.updateCategoryAccommodationUnit(categoryAccommodationUnit);
    }

    @DeleteMapping("/delete")
    public void deleteCategoryAccommodationUnitById(@RequestBody CategoryAccommodationUnit categoryAccommodationUnit) {
        categoryAccommodationUnitService.deleteCategoryAccommodationUnitById(categoryAccommodationUnit.getId());
    }

}
