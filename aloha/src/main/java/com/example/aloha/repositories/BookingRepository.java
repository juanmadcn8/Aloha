package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
