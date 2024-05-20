package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.AccommodationUnit;

public interface AccommodationUnitService {
    public List<AccommodationUnit> getAccommodationUnits();

    public Optional<AccommodationUnit> getAccommodationUnitById(Long id);

    public List<AccommodationUnit> getAccommodationUnitsByAccommodationLocation(String location);

    public void createAccommodationUnit(AccommodationUnit accommodationUnit);

    public void deleteAccommodationUnitById(Long id);

    public void updateAccommodationUnit(AccommodationUnit accommodationUnit);

    public List<AccommodationUnit> getAccommodationUnitsByCategoryHotel();

    public List<AccommodationUnit> getAccommodationUnitsByCategoryBungalow();

    public List<AccommodationUnit> getAccommodationUnitsByCategoryHostel();

    public List<AccommodationUnit> getAccommodationUnitsByCategoryHouse();

    public List<AccommodationUnit> getAccommodationUnitsByCategories(Boolean[] categories);
}
