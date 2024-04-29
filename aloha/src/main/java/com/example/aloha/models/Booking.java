package com.example.aloha.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date checkIn;

    private Date checkOut;

    @OneToOne
    @JoinColumn(name = "accommodation_unit_id")
    private AccommodationUnit accommodationUnit;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
