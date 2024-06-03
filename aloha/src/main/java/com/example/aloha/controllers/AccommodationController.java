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

import com.example.aloha.models.Accommodation;
import com.example.aloha.services.AccommodationService;
import com.example.aloha.services.AccommodationUnitService;
import com.example.aloha.services.AccommodationUnitServiceService;
import com.example.aloha.services.BookingService;
import com.example.aloha.services.ImageService;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @Autowired
    private AccommodationUnitServiceService accommodationUnitServiceService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ImageService imageService;

    @GetMapping()
    public List<Accommodation> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @GetMapping("/location/{location}")
    public List<Accommodation> getAccommodationsByLocation(@PathVariable String location) {
        return accommodationService.getAccommodationsByLocation(location);
    }

    @GetMapping("/{id}")
    public Accommodation getAccommodationById(@PathVariable Long id) {
        return accommodationService.getAccommodationById(id);
    }

    @PostMapping("/create")
    public void createAccommodation(@RequestBody Accommodation accommodation) {
        accommodationService.createAccommodation(accommodation);
    }

    @PutMapping("/update")
    public void updateAccommodation(@RequestBody Accommodation accommodation) {
        accommodationService.updateAccommodation(accommodation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccommodation(@PathVariable Long id) {
        imageService.deleteImagesByAccommodation(id);
        bookingService.deleteBookingByIdAccommodationUnit(id);
        accommodationUnitServiceService.deleteAccommodationUnitServiceByAccommodationUnitId(id);
        accommodationUnitService.deleteAccommodationUnitByIdAccommodation(id);
        accommodationService.deleteAccommodation(id);
    }

}
