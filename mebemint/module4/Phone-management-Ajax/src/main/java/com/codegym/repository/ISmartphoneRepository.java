package com.codegym.repository;

import com.codegym.model.Smartphone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone , Long > {


    @Query("SELECT s FROM Smartphone s")
    public Iterable<Smartphone> findAllSmartPhone();

    @Query("SELECT s FROM Smartphone  s WHERE s.id = ?1")
    public Optional<Smartphone> findAllById(Long id);

// Query sửa vs xoá trên @Query phải có @Modifing
}

