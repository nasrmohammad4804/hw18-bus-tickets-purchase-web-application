package com.example.demo.repository;

import com.example.demo.domain.RegisteredUser;
import org.springframework.data.repository.CrudRepository;

public interface RegisteredUserRepository extends CrudRepository<RegisteredUser,Long> {
}
