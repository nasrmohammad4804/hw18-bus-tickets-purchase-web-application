package com.example.demo.service;

import com.example.demo.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketService extends CrudRepository<Ticket,Long> {
    List<Ticket> findAllTicketByUserId(Long userId);
    Ticket findWithId(Long id);
}
