package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Setter
@Getter

public abstract class User implements Serializable {
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @Column(name = FIRST_NAME)
    protected String firstName;

    @Column(name = LAST_NAME)
    protected String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
