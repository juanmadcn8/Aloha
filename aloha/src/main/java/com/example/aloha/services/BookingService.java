package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.Booking;

public interface BookingService {
    public List<Booking> getAllBookings();

    public Optional<Booking> getBookingById(Long id);

    public void createBooking(Booking booking);

    public void updateBooking(Booking booking);

    public void deleteBooking(Long id);

    public List<Booking> getBookingsByClientId(Long id);
}
