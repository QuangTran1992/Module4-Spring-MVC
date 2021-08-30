package com.codegym.service;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.util.Optionals;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
