package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT * FROM booking WHERE client_id = :id", nativeQuery = true)
    List<Booking> findByClientId(Long id);
}
