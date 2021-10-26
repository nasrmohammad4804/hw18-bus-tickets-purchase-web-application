package com.example.demo.service;

import com.example.demo.domain.Ticket;
import com.example.demo.domain.Travel;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TravelService extends CrudRepository<Travel,Long> {

    void addDefaultTravel();
    List<Travel> findAllTravelByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);

}
