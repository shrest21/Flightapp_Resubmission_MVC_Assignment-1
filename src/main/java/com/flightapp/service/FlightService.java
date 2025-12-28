package com.flightapp.service;
import com.flightapp.dto.FlightInventory;
import com.flightapp.model.Flight;

public interface FlightService {
    Flight addFlight(FlightInventory flight);
}