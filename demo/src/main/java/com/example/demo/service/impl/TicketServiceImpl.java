package com.example.demo.service.impl;

import com.example.demo.domain.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public <S extends Ticket> S save(S entity) {
        return ticketRepository.save(entity);
    }

    @Override
    public <S extends Ticket> Iterable<S> saveAll(Iterable<S> entities) {
        return ticketRepository.saveAll(entities);
    }

    @Override
    public Optional<Ticket> findById(Long aLong) {
        return ticketRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return ticketRepository.existsById(aLong);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Iterable<Ticket> findAllById(Iterable<Long> longs) {
        return ticketRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return ticketRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        ticketRepository.deleteById(aLong);
    }

    @Override
    public void delete(Ticket entity) {
        ticketRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        ticketRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Ticket> entities) {
        ticketRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        ticketRepository.deleteAll();
    }

    @Override
    public List<Ticket> findAllTicketByUserId(Long userId) {
       return ticketRepository.findAllTicketByUserId(userId);
    }

    @Override
    public Ticket findWithId(Long id) {
        return ticketRepository.findWithId(id);
    }
}
