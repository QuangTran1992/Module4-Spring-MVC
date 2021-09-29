package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
//    Iterable<Customer> findAllByProvince(Province province);
//    Page<Customer> findAllByFullNameContaining(String fullName, Pageable pageable);

}
