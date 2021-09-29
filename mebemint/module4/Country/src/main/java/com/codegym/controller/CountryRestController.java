package com.codegym.controller;


import com.codegym.model.Country;
import com.codegym.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private ICountryService countryService;

    @GetMapping("/countries/list")
    public ModelAndView showCountryList() {
        List<Country> countryList = (List<Country>) countryService.findAll();

        return new ModelAndView("/country/list", "data", countryList);
    }



}


