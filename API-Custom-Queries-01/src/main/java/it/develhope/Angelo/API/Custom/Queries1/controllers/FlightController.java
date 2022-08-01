package it.develhope.Angelo.API.Custom.Queries1.controllers;

import it.develhope.Angelo.API.Custom.Queries1.entities.Flight;
import it.develhope.Angelo.API.Custom.Queries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static it.develhope.Angelo.API.Custom.Queries1.entities.FlightStatus.ON_TIME;

@RestController
@RequestMapping("/flights") //mapped on flights
public class FlightController {

    //all the string values are randomly generated (using random.ints())
    public String generateRandomValueForFlight() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    @Autowired
    private FlightRepository flightRepository;

    //provisioning of 50 flights
    @GetMapping("/loadFlight")
    public List<Flight> getAllLoadFlightX(){
        List<Flight> flights = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            flights.add(new Flight(i, generateRandomValueForFlight(), generateRandomValueForFlight(),generateRandomValueForFlight(),ON_TIME));
        }
        flightRepository.saveAllAndFlush(flights);
        return flights;
    }

    //retrieving all the flights in the db
    @GetMapping()
    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }
}
