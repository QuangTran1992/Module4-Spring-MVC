package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;


@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

//        Cách 1


//        @Transactional
//        @Modifying
//        @Query(value = "UPDATE Customer SET Salary = Salary + ?1 WHERE id = ?2")
//        void deposit(BigDecimal salary, Long id);

        @Transactional
        @Modifying
        @Query(value = "UPDATE Customer SET Salary = Salary + :salary WHERE id = :id")
        void deposit(@Param("salary") BigDecimal salary, @Param("id") Long id);


        @Transactional
        @Modifying
        @Query(value = "UPDATE customers SET c_Salary = c_Salary - ?1 where id = ?2",nativeQuery = true)
        void withdraw(BigDecimal c_Salary, Long id);



}
