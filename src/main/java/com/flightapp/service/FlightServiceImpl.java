package com.flightapp.service;
import com.flightapp.dto.FlightInventory;
import com.flightapp.model.Flight;
import com.flightapp.repo.FlightRepository;
import org.springframework.stereotype.Service;

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
}
