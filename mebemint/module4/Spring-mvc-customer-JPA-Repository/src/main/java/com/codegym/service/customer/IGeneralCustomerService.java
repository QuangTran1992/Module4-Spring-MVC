package com.codegym.service.customer;

import com.codegym.exception.CustomerException;

import java.util.List;

public interface IGeneralCustomerService<T> {
    List<T> findAll()  ;

    T findById(Long id);

    T save(T t) throws CustomerException;

    void remove(Long id);

}
