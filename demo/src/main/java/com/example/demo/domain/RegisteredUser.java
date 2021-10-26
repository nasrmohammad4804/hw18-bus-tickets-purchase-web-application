package com.example.demo.domain;

import com.example.demo.domain.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class RegisteredUser extends User{


    @Enumerated(EnumType.STRING)
    private Gender gender;

    public RegisteredUser(Gender gender) {
        this.gender = gender;
    }

    public RegisteredUser(String firstName, String lastName, Gender gender) {
        super(firstName, lastName);
        this.gender = gender;
    }
}
