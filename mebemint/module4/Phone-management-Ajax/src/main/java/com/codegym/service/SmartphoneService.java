package com.codegym.service;

import com.codegym.model.Smartphone;
import com.codegym.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    ISmartphoneRepository iSmartphoneRepository;


    @Override
    public Iterable<Smartphone> findAll() {
        return iSmartphoneRepository.findAllSmartPhone();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return iSmartphoneRepository.findAllById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return  iSmartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        iSmartphoneRepository.deleteById(id);


    }
}
