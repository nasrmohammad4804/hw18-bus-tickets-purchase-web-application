package com.example.demo.repository;

import com.example.demo.domain.Travel;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TravelRepository extends CrudRepository<Travel, Long> {

    List<Travel> findAllTravelByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);

}
