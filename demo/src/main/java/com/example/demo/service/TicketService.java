package com.example.demo.service;

import com.example.demo.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TicketService extends CrudRepository<Ticket,Long> {
    List<Ticket> findAllTicketByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);

    void addDefaultTicket();
    List<Ticket> findAllByUserId(Long userId);

}
