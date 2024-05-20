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

import com.example.aloha.models.AccommodationUnit;
import com.example.aloha.services.AccommodationUnitService;

@RestController
@RequestMapping("/api/accommodation-unit")
public class AccommodationUnitController {

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @GetMapping()
    public List<AccommodationUnit> getAccommodationUnits() {
        return accommodationUnitService.getAccommodationUnits();
    }

    @GetMapping("/location/{location}")
    public List<AccommodationUnit> getAccommodationUnitsByAccommodationLocation(@PathVariable String location) {
        return accommodationUnitService.getAccommodationUnitsByAccommodationLocation(location);
    }

    @GetMapping("/{id}")
    public Optional<AccommodationUnit> getAccommodationUnitById(@PathVariable Long id) {
        return accommodationUnitService.getAccommodationUnitById(id);
    }

    @GetMapping("/category/hotel")
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHotel() {
        return accommodationUnitService.getAccommodationUnitsByCategoryHotel();
    }

    @PostMapping("/create")
    public void createAccommodationUnit(@RequestBody AccommodationUnit accommodationUnit) {
        accommodationUnitService.createAccommodationUnit(accommodationUnit);
    }

    @PutMapping("/update")
    public void updateAccommodationUnit(@RequestBody AccommodationUnit accommodationUnit) {
        accommodationUnitService.updateAccommodationUnit(accommodationUnit);
    }

    @DeleteMapping("/delete")
    public void deleteAccommodationUnitById(@RequestBody AccommodationUnit accommodationUnit) {
        accommodationUnitService.deleteAccommodationUnitById(accommodationUnit.getId());
    }

}
