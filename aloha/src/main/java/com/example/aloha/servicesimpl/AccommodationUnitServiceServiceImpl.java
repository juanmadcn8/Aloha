package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.AccommodationUnitService;
import com.example.aloha.repositories.AccommodationUnitServiceRepository;
import com.example.aloha.services.AccommodationUnitServiceService;

@Service
public class AccommodationUnitServiceServiceImpl implements AccommodationUnitServiceService {

    @Autowired
    private AccommodationUnitServiceRepository accommodationUnitServiceRepository;

    @Override
    public List<AccommodationUnitService> getAccommodationUnitServices() {
        return accommodationUnitServiceRepository.findAll();
    }

    @Override
    public Optional<AccommodationUnitService> getAccommodationUnitServiceById(Long id) {
        return accommodationUnitServiceRepository.findById(id);
    }

    @Override
    public void createAccommodationUnitService(AccommodationUnitService accommodationUnitService) {
        accommodationUnitServiceRepository.save(accommodationUnitService);
    }

    @Override
    public void deleteAccommodationUnitServiceById(Long id) {
        accommodationUnitServiceRepository.deleteById(id);
    }

    @Override
    public void updateAccommodationUnitService(AccommodationUnitService accommodationUnitService) {
        accommodationUnitServiceRepository.save(accommodationUnitService);
    }

}
