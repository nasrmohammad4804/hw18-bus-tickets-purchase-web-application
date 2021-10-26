package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(name = "", columnNames = {Ticket.TRAVEL_ID})})
public class Ticket implements Serializable {

    public static final String TRAVEL_ID = "travel_id";
    public static final String TICKET_ID = "ticket_id";
    private static final String FLIGHT_DATE = "flight_date";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TRAVEL_ID)
    private Long travelId;

    @Column(name = FLIGHT_DATE)
    private LocalDate flightDate;

    @JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalTime takeOfTime;

    private String origin;
    private String destination;

    @Column(columnDefinition = "tinyint(1)")
    private Boolean isDeleted;


    @OneToOne(cascade = CascadeType.ALL)
    private RegisteredUser registeredUser;

    private int capacity;

    public Ticket(Long travelId, LocalDate flightDate, LocalTime takeOfTime, String origin, String destination, int capacity) {
        this.travelId = travelId;
        this.flightDate = flightDate;
        this.takeOfTime = takeOfTime;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
    }


    @ManyToMany()
    @JoinTable(name = MajorUser.USER_TICKET_TABLE,joinColumns = {@JoinColumn(name = MajorUser.USER_ID)},
            inverseJoinColumns = {@JoinColumn(name = Ticket.TICKET_ID)})
    private List<MajorUser> majorUserList=new LinkedList<>();
}
