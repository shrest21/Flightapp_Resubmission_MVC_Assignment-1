package com.flightapp.service;
import com.flightapp.dto.FlightInventory;
import com.flightapp.dto.FlightSearch;
import com.flightapp.dto.FlightSearchResponse;
import com.flightapp.model.Flight;
import java.util.List;

public interface FlightService {
    Flight addFlight(FlightInventory flight);
    List<FlightSearchResponse> searchFlights(FlightSearch request);
}