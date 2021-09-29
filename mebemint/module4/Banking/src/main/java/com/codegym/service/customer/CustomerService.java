package com.codegym.service.customer;

import com.codegym.exception.CustomerException;
import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Iterable<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Optional<Customer> findById(Long id) {
//        TypedQuery<Customer> query = (TypedQuery<Customer>) em.createNativeQuery("SELECT * FROM customers WHERE id = ?",Customer.class);
//        query.setParameter(1,id);
//        Customer customer = query.getSingleResult();
//        return Optional.of(customer);
        return customerRepository.findById(id);
    }


    @Override
    public void save(Customer customer) throws CustomerException {
        customerRepository.save(customer);
    }


    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deposit(BigDecimal salary, Long id) {
        customerRepository.deposit(salary,id);
    }

    @Override
    public void withdraw(BigDecimal c_Salary, Long id) {
        customerRepository.withdraw(c_Salary, id);
    }
}
