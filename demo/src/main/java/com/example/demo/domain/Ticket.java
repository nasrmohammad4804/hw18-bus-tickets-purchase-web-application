package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "TicketWithTravel",
attributeNodes = {@NamedAttributeNode(value = "travel")})

public class Ticket implements Serializable {

    public static final String TRAVEL_ID = "travel_id";
    public static final String TICKET_ID = "ticket_id";
    private static final String FLIGHT_DATE = "flight_date";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = TRAVEL_ID)
    private Travel travel;

    @ManyToOne
    @JoinColumn(name = MajorUser.MAJOR_USER_ID)
    private MajorUser majorUser;

    @Embedded
    private RegisteredUser registeredUser;

    public Ticket(Travel travel, RegisteredUser registeredUser) {
        this.travel = travel;
        this.registeredUser = registeredUser;
    }
}
