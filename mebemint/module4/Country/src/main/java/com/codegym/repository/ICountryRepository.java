package com.codegym.repository;

import com.codegym.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICountryRepository extends JpaRepository<Country, Long> {


}
