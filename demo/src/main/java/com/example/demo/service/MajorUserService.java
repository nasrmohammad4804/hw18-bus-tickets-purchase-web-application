package com.example.demo.service;

import com.example.demo.domain.MajorUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MajorUserService extends CrudRepository<MajorUser,Long> {


    Optional<MajorUser> findUserByUserName(String userName);
}
