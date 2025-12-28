package com.flightapp.dto;
import java.time.LocalDateTime;
import lombok.Data;
@Data
public class FlightSearchResponse {
    private Long id;
    private String airlineName;
    private LocalDateTime flightDateTime;
    private double price;
    private int availableSeats;
}
