package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public static final String TICKET_ID = "ticket_id";
    private static final String FLIGHT_DATE = "flight_date";



    @Column(name = FLIGHT_DATE)
    private LocalDate flightDate;

    @JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalTime takeOfTime;

    private String origin;
    private String destination;




   @OneToMany(cascade = CascadeType.ALL,mappedBy = "travel")
   private List<Ticket> tickets=new LinkedList<>();

    private int capacity;

    public Travel(LocalDate flightDate, LocalTime takeOfTime, String origin, String destination, int capacity) {
        this.flightDate = flightDate;
        this.takeOfTime = takeOfTime;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
    }
}
