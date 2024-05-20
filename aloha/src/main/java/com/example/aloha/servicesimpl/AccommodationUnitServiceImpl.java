package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.AccommodationUnit;
import com.example.aloha.repositories.AccommodationUnitRepository;
import com.example.aloha.services.AccommodationUnitService;

@Service
public class AccommodationUnitServiceImpl implements AccommodationUnitService {

    @Autowired
    private AccommodationUnitRepository accommodationUnitRepository;

    @Override
    public List<AccommodationUnit> getAccommodationUnits() {
        return accommodationUnitRepository.getAll();
    }

    @Override
    public Optional<AccommodationUnit> getAccommodationUnitById(Long id) {
        return accommodationUnitRepository.findById(id);
    }

    @Override
    public void createAccommodationUnit(AccommodationUnit accommodationUnit) {
        accommodationUnitRepository.save(accommodationUnit);
    }

    @Override
    public void deleteAccommodationUnitById(Long id) {
        accommodationUnitRepository.deleteById(id);
    }

    @Override
    public void updateAccommodationUnit(AccommodationUnit accommodationUnit) {
        accommodationUnitRepository.save(accommodationUnit);
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByAccommodationLocation(String location) {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getAccommodation().getLocation().equals(location))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHotel() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("hotel"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryBungalow() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("bungalow"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHostel() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("hostel"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHouse() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("house"))
                .toList();
    }

}
