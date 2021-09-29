package com.codegym.service;

import com.codegym.IGeneralService;
import com.codegym.model.Country;
import com.codegym.repository.ICountryRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;


    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Country> findById(Long id)
    {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country)
    {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
    countryRepository.deleteById(id);
    }
}
