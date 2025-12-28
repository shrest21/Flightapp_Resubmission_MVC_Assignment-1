package com.flightapp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FlightInventory {

    private String airlineName;
    private String fromPlace;
    private String toPlace;
    private LocalDateTime flightDateTime;
    private double price;
    private int totalSeats;
}
