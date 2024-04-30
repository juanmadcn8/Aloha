package com.example.aloha.services;

import com.example.aloha.models.AccommodationUnitService;

import java.util.List;
import java.util.Optional;

public interface AccommodationUnitServiceService {

    public List<AccommodationUnitService> getAccommodationUnitServices();

    public Optional<AccommodationUnitService> getAccommodationUnitServiceById(Long id);

    public void createAccommodationUnitService(AccommodationUnitService accommodationUnitService);

    public void deleteAccommodationUnitServiceById(Long id);

    public void updateAccommodationUnitService(AccommodationUnitService accommodationUnitService);
}
