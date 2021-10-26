package com.example.demo.service.impl;

import com.example.demo.domain.Travel;
import com.example.demo.repository.TravelRepository;
import com.example.demo.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository repository;

    @Override
    public <S extends Travel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Travel> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<Travel> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return repository.existsById(aLong);
    }

    @Override
    public Iterable<Travel> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Travel> findAllById(Iterable<Long> longs) {
        return repository.findAllById(longs);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public void delete(Travel entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Travel> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }


    @Override
    public void addDefaultTravel() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        List<Travel> travels = new LinkedList<>();

        LocalTime.parse(LocalTime.now().format(formatter));
        travels.add(new Travel(LocalDate.parse("2021-10-26"), LocalTime.parse(LocalTime.parse("20:30:15").format(formatter)), "tehran", "isfahan", 40));
        travels.add(new Travel(LocalDate.parse("2021-10-26"), LocalTime.parse(LocalTime.parse("18:00:15").format(formatter)), "tehran", "isfahan", 55));
        travels.add(new Travel(LocalDate.parse("2021-10-27"), LocalTime.parse(LocalTime.parse("19:45:00").format(formatter)), "tehran", "isfahan", 38));
        travels.add(new Travel(LocalDate.parse("2021-10-27"), LocalTime.parse(LocalTime.parse("13:25:48").format(formatter)), "tehran", "isfahan", 60));

        travels.forEach(x -> repository.save(x));
    }

    @Override
    public List<Travel> findAllTravelByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        return repository.findAllTravelByOriginAndDestinationAndFlightDate(origin, destination, flightDate)
                .stream().filter(x -> x.getCapacity() > 0 && (currentDateTime.isBefore(x.getFlightDate()
                        .atTime(x.getTakeOfTime())))).collect(Collectors.toList());
    }

}
