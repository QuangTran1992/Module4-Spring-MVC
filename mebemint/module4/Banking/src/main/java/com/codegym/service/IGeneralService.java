package com.codegym.service;

import com.codegym.exception.CustomerException;
import net.bytebuddy.dynamic.DynamicType;

import java.util.Optional;


public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t) throws CustomerException;

    void remove(Long id);



}
