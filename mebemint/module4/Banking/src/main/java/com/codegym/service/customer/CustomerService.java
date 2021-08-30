package com.codegym.service.customer;

import com.codegym.exception.CustomerException;
import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService implements IGeneralService<Customer> {
@Autowired
private ICustomerRepository customerRepository;

@PersistenceContext
private EntityManager em;

    @Override
    public Iterable<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c",Customer.class);
        return  query.getResultList();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        TypedQuery<Customer> query = (TypedQuery<Customer>) em.createNativeQuery("SELECT * FROM customers WHERE id =: id",Customer.class);
        query.setParameter("id",id);
        Customer customer = query.getSingleResult();
        return Optional.of(customer);
    }

    @Override
    public void save(Customer customer) throws CustomerException {
      customerRepository.save(customer);
    }


    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
