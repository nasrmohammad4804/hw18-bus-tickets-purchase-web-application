package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(uniqueConstraints = {
        @UniqueConstraint(name = "define_unique",columnNames = {MajorUser.USER_NAME})
})
public class MajorUser extends User  {

    public static final String USER_NAME = "user_name";
    public static final String USER_TICKET_TABLE="user_ticket";
    public static final String USER_ID="user_id";

    @Column(name = USER_NAME)
    @NotBlank(message = "userName is mandatory")
    private String userName;

    @NotBlank(message = "password is mandatory")
    private String password;

    @ManyToMany(mappedBy = "majorUserList")
    private List<Ticket> ticketList=new ArrayList<>();





}
