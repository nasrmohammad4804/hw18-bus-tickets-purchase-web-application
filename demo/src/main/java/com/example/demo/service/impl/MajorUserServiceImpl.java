package com.example.demo.service.impl;

import com.example.demo.domain.MajorUser;
import com.example.demo.repository.MajorUserRepository;
import com.example.demo.service.MajorUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MajorUserServiceImpl implements MajorUserService {


    @Autowired
    private MajorUserRepository majorUserRepository;


    @Override
    public <S extends MajorUser> S save(S entity) {
        return majorUserRepository.save(entity);
    }

    @Override
    public <S extends MajorUser> Iterable<S> saveAll(Iterable<S> entities) {
       return majorUserRepository.saveAll(entities);
    }

    @Override
    public Optional<MajorUser> findById(Long aLong) {
        return majorUserRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
       return majorUserRepository.existsById(aLong);
    }

    @Override
    public Iterable<MajorUser> findAll() {
       return majorUserRepository.findAll();
    }

    @Override
    public Iterable<MajorUser> findAllById(Iterable<Long> longs) {
       return majorUserRepository.findAllById(longs);
    }

    @Override
    public long count() {
      return   majorUserRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        majorUserRepository.deleteById(aLong);
    }

    @Override
    public void delete(MajorUser entity) {
        majorUserRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        majorUserRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends MajorUser> entities) {
        majorUserRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        majorUserRepository.deleteAll();
    }

    @Override
    public Optional<MajorUser> findUserByUserName(String userName) {
        return majorUserRepository.findByUserName(userName);
    }


}
