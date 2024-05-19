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

import com.example.aloha.models.Booking;
import com.example.aloha.services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/client/{id}")
    public List<Booking> getBookingsByClientId(@PathVariable Long id) {
        return bookingService.getBookingsByClientId(id);
    }

    @PostMapping("/create")
    public void createBooking(@RequestBody Booking booking) {
        System.out.println(booking);
        bookingService.createBooking(booking);
    }

    @PutMapping("/update")
    public void updateBooking(@RequestBody Booking booking) {
        bookingService.updateBooking(booking);
    }

    @DeleteMapping("/delete")
    public void deleteBooking(@RequestBody Booking booking) {
        bookingService.deleteBooking(booking.getId());
    }

}
