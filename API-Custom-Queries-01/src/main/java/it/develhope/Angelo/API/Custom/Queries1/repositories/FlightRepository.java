package it.develhope.Angelo.API.Custom.Queries1.repositories;

import it.develhope.Angelo.API.Custom.Queries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
