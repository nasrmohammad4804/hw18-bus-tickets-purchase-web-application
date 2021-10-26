package com.example.demo.repository;

import com.example.demo.domain.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

//    @Query("select t from Ticket as t where t.origin=:#{#origin} and t.destination=:#{#destination} and " +
//            "t.flightDate=:#{#flightDate} ")
    List<Ticket> findAllByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);

    @Query("select t from MajorUser as m join m.ticketList as t where m.id=:#{#userId}  ")
    List<Ticket> findAllByUserId(Long userId);
}
