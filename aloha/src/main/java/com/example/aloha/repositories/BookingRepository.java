package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aloha.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
