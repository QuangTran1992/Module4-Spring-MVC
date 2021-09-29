package com.codegym.controller.api;

import com.codegym.model.Country;
import com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryRestAPI {

    @Autowired
    private ICountryService countryService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Country>> showListCountry() {
        Iterable<Country> countries = countryService.findAll();
        if(((List) countries).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Country> save(@RequestBody Country country){

        return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> delete(@PathVariable Long id) {
        Optional<Country> countryOptional = countryService.findById(id);

        if (!countryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.remove(id);
        return new ResponseEntity<>(countryOptional.get(), HttpStatus.NO_CONTENT);
    }
}
