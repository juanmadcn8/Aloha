package com.example.aloha.services;

import java.util.List;

import com.example.aloha.models.Accommodation;

public interface AccommodationService {

    public List<Accommodation> getAllAccommodations();

    public Accommodation getAccommodationById(Long id);

    public List<Accommodation> getAccommodationsByLocation(String location);

    public void createAccommodation(Accommodation accommodation);

    public void updateAccommodation(Accommodation accommodation);

    public void deleteAccommodation(Long id);
}
