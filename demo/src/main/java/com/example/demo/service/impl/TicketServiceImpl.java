package com.example.demo.service.impl;

import com.example.demo.domain.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<Ticket> findAllTicketByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate) {

        LocalDate currentDate = LocalDate.now();
        Predicate<LocalDate> predicate = (currentDate::isEqual);
      Predicate<LocalDate> result=  predicate.or(currentDate::isBefore);

        return ticketRepository.findAllByOriginAndDestinationAndFlightDate(origin, destination, flightDate)
                .stream().filter(x -> x.getCapacity() > 0 && (result.test(x.getFlightDate()))).collect(Collectors.toList());
    }

    @Override
    public void addDefaultTicket() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        List<Ticket> tickets = new LinkedList<>();

        LocalTime.parse(LocalTime.now().format(formatter));
        tickets.add(new Ticket(457L, LocalDate.parse("2021-10-26"), LocalTime.parse(LocalTime.parse("14:30:15").format(formatter)), "tehran", "isfahan", 40));
        tickets.add(new Ticket(571L, LocalDate.parse("2021-10-26"), LocalTime.parse(LocalTime.parse("17:00:15").format(formatter)), "tehran", "isfahan", 55));
        tickets.add(new Ticket(128L, LocalDate.parse("2021-10-27"), LocalTime.parse(LocalTime.parse("19:45:00").format(formatter)), "tehran", "isfahan", 38));
        tickets.add(new Ticket(649L, LocalDate.parse("2021-10-27"), LocalTime.parse(LocalTime.parse("13:25:48").format(formatter)), "tehran", "isfahan", 60));

        tickets.forEach(x -> ticketRepository.save(x));
    }

    @Override
    public List<Ticket> findAllByUserId(Long userId) {
        return ticketRepository.findAllByUserId(userId);
    }


}
