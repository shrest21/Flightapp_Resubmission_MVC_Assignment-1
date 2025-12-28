package com.flightapp.controller;
import com.flightapp.dto.FlightSearch;
import com.flightapp.dto.FlightSearchResponse;
import com.flightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.flightapp.dto.FlightInventory;
import com.flightapp.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/airline/inventory/add")
    public ResponseEntity<Flight> addFlightInventory(@RequestBody FlightInventory request) {
        Flight savedFlight = flightService.addFlight(request);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<List<FlightSearchResponse>> searchFlights(@RequestBody FlightSearch request){
        List<FlightSearchResponse> results = flightService.searchFlights(request);
        return ResponseEntity.ok(results);
    }
}
