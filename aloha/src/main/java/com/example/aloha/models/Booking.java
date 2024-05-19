package com.example.aloha.models;

import java.sql.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String checkIn;

    private Date checkOut;

    @OneToOne
    @JoinColumn(name = "accommodation_unit_id")
    private AccommodationUnit accommodationUnit;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
