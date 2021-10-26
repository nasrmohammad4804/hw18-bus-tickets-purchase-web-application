package com.example.demo.repository;

import com.example.demo.domain.Ticket;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Query("select t from Ticket as t where t.majorUser.id=:#{#userId}")
    List<Ticket> findAllTicketByUserId(Long userId);


    @EntityGraph(value = "TicketWithTravel",type = EntityGraph.EntityGraphType.FETCH)
    @Query("select t from Ticket  as t where t.id=:#{#id}")
    Ticket findWithId(Long id);

}
