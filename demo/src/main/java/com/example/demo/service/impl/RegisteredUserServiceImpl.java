package com.example.demo.service.impl;

import com.example.demo.domain.RegisteredUser;
import com.example.demo.repository.RegisteredUserRepository;
import com.example.demo.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RegisteredUserServiceImpl implements RegisteredUserService {

    @Autowired
    private RegisteredUserRepository repository;

    @Override
    public <S extends RegisteredUser> S save(S entity) {
       return  repository.save(entity);
    }

    @Override
    public <S extends RegisteredUser> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<RegisteredUser> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
       return repository.existsById(aLong);
    }

    @Override
    public Iterable<RegisteredUser> findAll() {
      return repository.findAll();
    }

    @Override
    public Iterable<RegisteredUser> findAllById(Iterable<Long> longs) {
       return repository.findAllById(longs);
    }

    @Override
    public long count() {
       return repository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public void delete(RegisteredUser entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends RegisteredUser> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
