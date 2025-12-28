package com.flightapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flightapp.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
