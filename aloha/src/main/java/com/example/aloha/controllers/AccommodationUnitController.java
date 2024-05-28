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

    @GetMapping("/service/{services}")
    public List<AccommodationUnit> getAccommodationUnitsByService(@PathVariable Boolean[] services) {
        return accommodationUnitService.getAccommodationUnitsByService(services);
    }

    @GetMapping("/{id}")
    public AccommodationUnit getAccommodationUnitById(@PathVariable Long id) {
        return accommodationUnitService.getAccommodationUnitById(id);
    }

    @GetMapping("/category/hotels")
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHotel() {
        return accommodationUnitService.getAccommodationUnitsByCategoryHotel();
    }

    @GetMapping("/category/{categories}")
    public List<AccommodationUnit> getAccommodationUnitsByCategory(@PathVariable Boolean[] categories) {
        return accommodationUnitService.getAccommodationUnitsByCategories(categories);
    }

    @GetMapping("/category/bungalows")
    public List<AccommodationUnit> getAccommodationUnitsByCategoryBungalow() {
        return accommodationUnitService.getAccommodationUnitsByCategoryBungalow();
    }

    @GetMapping("/category/hostels")
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHostel() {
        return accommodationUnitService.getAccommodationUnitsByCategoryHostel();
    }

    @GetMapping("/category/houses")
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHouse() {
        return accommodationUnitService.getAccommodationUnitsByCategoryHouse();
    }

    @GetMapping("/price/{price}")
    public List<AccommodationUnit> getAccommodationUnitsByMaxPrice(@PathVariable Double price) {
        return accommodationUnitService.getAccommodationUnitsByMaxPrice(price);
    }

    @GetMapping("/location/{location}/price/{price}/services/{services}/categories/{categories}")
    public List<AccommodationUnit> getAccommodationUnitsByLocationMaxPriceServicesAndCategories(
            @PathVariable String location,
            @PathVariable Double price, @PathVariable Boolean[] services, @PathVariable Boolean[] categories) {
        return accommodationUnitService.getAccommodationUnitsByLocationMaxPriceServicesAndCategories(location, price,
                services, categories);
    }

    @PostMapping("/create")
    public void createAccommodationUnit(@RequestBody AccommodationUnit accommodationUnit) {
        accommodationUnitService.createAccommodationUnit(accommodationUnit);
    }

    @PutMapping("/update")
    public void updateAccommodationUnit(@RequestBody AccommodationUnit accommodationUnit) {
        accommodationUnitService.updateAccommodationUnit(accommodationUnit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccommodationUnitById(@PathVariable Long id) {
        accommodationUnitService.deleteAccommodationUnitById(id);
    }

}
