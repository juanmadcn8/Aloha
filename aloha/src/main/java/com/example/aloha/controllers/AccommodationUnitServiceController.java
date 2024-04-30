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

import com.example.aloha.models.AccommodationUnitService;
import com.example.aloha.services.AccommodationUnitServiceService;

@RestController
@RequestMapping("/api/accommodation-unit-service")
public class AccommodationUnitServiceController {

    @Autowired
    private AccommodationUnitServiceService accommodationUnitServiceService;

    @GetMapping()
    public List<AccommodationUnitService> getAccommodationUnitServices() {
        return accommodationUnitServiceService.getAccommodationUnitServices();
    }

    @GetMapping("/{id}")
    public Optional<AccommodationUnitService> getAccommodationUnitServiceById(@PathVariable Long id) {
        return accommodationUnitServiceService.getAccommodationUnitServiceById(id);
    }

    @PostMapping("/create")
    public void createAccommodationUnitService(@RequestBody AccommodationUnitService accommodationUnitService) {
        accommodationUnitServiceService.createAccommodationUnitService(accommodationUnitService);
    }

    @PutMapping("/update")
    public void updateAccommodationUnitService(@RequestBody AccommodationUnitService accommodationUnitService) {
        accommodationUnitServiceService.updateAccommodationUnitService(accommodationUnitService);
    }

    @DeleteMapping("/delete")
    public void deleteAccommodationUnitServiceById(@RequestBody AccommodationUnitService accommodationUnitService) {
        accommodationUnitServiceService.deleteAccommodationUnitServiceById(accommodationUnitService.getId());
    }

}
