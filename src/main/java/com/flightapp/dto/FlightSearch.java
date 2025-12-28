package com.flightapp.dto;
import java.time.LocalDate;
import lombok.Data;

@Data
public class FlightSearch{
    private String fromPlace;
    private String toPlace;
    private LocalDate journeyDate;
}
