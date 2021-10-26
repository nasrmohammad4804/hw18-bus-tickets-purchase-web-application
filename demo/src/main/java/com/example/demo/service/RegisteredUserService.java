package com.example.demo.service;

import com.example.demo.domain.RegisteredUser;
import org.springframework.data.repository.CrudRepository;

public interface RegisteredUserService extends CrudRepository<RegisteredUser, Long> {
}
