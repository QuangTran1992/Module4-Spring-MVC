package com.codegym.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "smartphones")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String producer;
    private String model;
    private  double price;

    @Override
    public String toString() {
        return producer+": "+model+" with price "+price;
    }


}
