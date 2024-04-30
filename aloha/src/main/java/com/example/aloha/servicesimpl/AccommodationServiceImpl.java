package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Accommodation;
import com.example.aloha.repositories.AccommodationRepository;
import com.example.aloha.services.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> getAccommodationById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public void createAccommodation(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    @Override
    public void updateAccommodation(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteAccommodation(Long id) {
        accommodationRepository.deleteById(id);
    }

}
