package com.codegym.service.customer;


import com.codegym.model.Customer;
import com.codegym.model.Province;


public interface ICustomerService extends IGeneralCustomerService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

}