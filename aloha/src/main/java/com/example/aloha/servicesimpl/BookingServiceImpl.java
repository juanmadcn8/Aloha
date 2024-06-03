package com.example.aloha.servicesimpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Booking;
import com.example.aloha.repositories.BookingRepository;
import com.example.aloha.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void createBooking(Booking booking) {
        List<Booking> bookings = bookingRepository.findByAccommodationUnitId(booking.getAccommodationUnit().getId());
        for (Booking b : bookings) {
            if (!isAvailable(b.getCheckIn(), b.getCheckOut(), booking.getCheckIn(), booking.getCheckOut())) {
                throw new IllegalArgumentException("Accommodation unit is not available for the selected period.");
            }
        }
        bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> getBookingsByClientId(Long id) {
        return bookingRepository.findByClientId(id);
    }

    @Override
    public void deleteBookingByIdClient(Long id) {
        bookingRepository.deleteByClientId(id);
    }

    @Override
    public void deleteBookingByIdAccommodationUnit(Long id) {
        bookingRepository.deleteByAccommodationUnitId(id);
    }

    @Override
    public List<Booking> getBookingsByAccommodationUnitId(Long id) {
        return bookingRepository.findByAccommodationUnitId(id);
    }

    private boolean isAvailable(Date checkIn, Date checkOut, Date newCheckIn, Date newCheckOut) {
        return (newCheckIn.before(checkIn) && newCheckOut.before(checkIn))
                || (newCheckIn.after(checkOut) && newCheckOut.after(checkOut));
    }

}
