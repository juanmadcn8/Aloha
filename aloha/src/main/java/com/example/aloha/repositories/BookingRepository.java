package com.example.aloha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Booking;

import jakarta.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT * FROM booking WHERE client_id = :id", nativeQuery = true)
    List<Booking> findByClientId(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM booking WHERE client_id = :id", nativeQuery = true)
    void deleteByClientId(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM booking WHERE accommodation_unit_id = :id", nativeQuery = true)
    void deleteByAccommodationUnitId(Long id);

    @Query(value = "SELECT * FROM booking WHERE accommodation_unit_id = :id", nativeQuery = true)
    List<Booking> findByAccommodationUnitId(Long id);
}
