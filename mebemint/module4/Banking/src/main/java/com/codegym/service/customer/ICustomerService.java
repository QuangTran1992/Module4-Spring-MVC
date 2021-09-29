package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.service.IGeneralService;

import java.math.BigDecimal;


public interface ICustomerService extends IGeneralService <Customer>{
    void deposit(BigDecimal salary, Long id);

    void withdraw(BigDecimal c_Salary, Long id);
}
