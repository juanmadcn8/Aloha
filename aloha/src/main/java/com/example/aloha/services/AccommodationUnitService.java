package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.AccommodationUnit;

public interface AccommodationUnitService {
    public List<AccommodationUnit> getAccommodationUnits();

    public AccommodationUnit getAccommodationUnitById(Long id);

    public List<AccommodationUnit> getAccommodationUnitsByAccommodationLocation(String location);

    public void createAccommodationUnit(AccommodationUnit accommodationUnit);

    public void deleteAccommodationUnitById(Long id);

    public void deleteAccommodationUnitByIdAccommodation(Long id);

    public void updateAccommodationUnit(AccommodationUnit accommodationUnit);

    public List<AccommodationUnit> getAccommodationUnitsByCategoryHotel();

    public List<AccommodationUnit> getAccommodationUnitsByCategoryBungalow();

    public List<AccommodationUnit> getAccommodationUnitsByCategoryHostel();

    public List<AccommodationUnit> getAccommodationUnitsByCategoryHouse();

    public List<AccommodationUnit> getAccommodationUnitsByCategories(Boolean[] categories);

    public List<AccommodationUnit> getAccommodationUnitsByService(Boolean[] service);

    public List<AccommodationUnit> getAccommodationUnitsByMaxPrice(Double maxPrice);

    public List<AccommodationUnit> getAccommodationUnitsByLocationMaxPriceServicesAndCategories(String location,
            Double maxPrice, Boolean[] services, Boolean[] categories);
}
