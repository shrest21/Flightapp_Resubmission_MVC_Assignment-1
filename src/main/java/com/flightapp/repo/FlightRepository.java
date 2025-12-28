package com.flightapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flightapp.model.Flight;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFromPlaceAndToPlaceAndFlightDateTimeBetween(String fromPlace, String toPlace, LocalDateTime start, LocalDateTime end);
}
