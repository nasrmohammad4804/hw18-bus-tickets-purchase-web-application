package com.example.demo.repository;

import com.example.demo.domain.MajorUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MajorUserRepository extends CrudRepository<MajorUser, Long> {
    Optional<MajorUser> findByUserName(String userName);

}
