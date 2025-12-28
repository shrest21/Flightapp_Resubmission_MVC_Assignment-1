package com.flightapp.service;
import com.flightapp.dto.FlightInventory;
import com.flightapp.dto.FlightSearch;
import com.flightapp.dto.FlightSearchResponse;
import com.flightapp.model.Flight;
import com.flightapp.repo.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    @Override
    public Flight addFlight(FlightInventory flightInventory) {
        Flight flight = new Flight();
        flight.setAirlineName(flightInventory.getAirlineName());
        flight.setFromPlace(flightInventory.getFromPlace());
        flight.setToPlace(flightInventory.getToPlace());
        flight.setFlightDateTime(flightInventory.getFlightDateTime());
        flight.setPrice(flightInventory.getPrice());
        flight.setTotalSeats(flightInventory.getTotalSeats());
        flight.setAvailableSeats(flightInventory.getTotalSeats());
        return flightRepository.save(flight);
    }
    @Override
    public List<FlightSearchResponse> searchFlights(FlightSearch request) {

        LocalDateTime startOfDay = request.getJourneyDate().atStartOfDay();
        LocalDateTime endOfDay = request.getJourneyDate().atTime(LocalTime.MAX);
        List<Flight> flights = flightRepository
                .findByFromPlaceAndToPlaceAndFlightDateTimeBetween(request.getFromPlace(), request.getToPlace(), startOfDay, endOfDay);
        return flights.stream().map(flight -> {
            FlightSearchResponse result = new FlightSearchResponse();
            result.setId(flight.getId());
            result.setAirlineName(flight.getAirlineName());
            result.setFlightDateTime(flight.getFlightDateTime());
            result.setPrice(flight.getPrice());
            result.setAvailableSeats(flight.getAvailableSeats());
            return result;
        }).collect(Collectors.toList());
    }
}
