package com.example.demo.domain;

import com.example.demo.domain.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class RegisteredUser extends User implements Serializable {

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
