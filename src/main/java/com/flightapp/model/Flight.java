package com.flightapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airlineName;
    private String fromPlace;
    private String toPlace;

    private LocalDateTime flightDateTime;

    private double price;
    private int totalSeats;
    private int availableSeats;
}
