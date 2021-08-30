package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_Name")
    @Size(min = 2 , max = 30)
    @NotEmpty(message = "khong duoc bo trong")
    private String Name;

    @Column(unique = true , name = "c_Phone")
    @Size(min = 10 )
    @NotEmpty(message = "khong duoc bo trong")
    private String Phone;

    @Column(unique = true , name = "c_Email")
    @NotEmpty(message = "khong duoc bo trong")
    private String Email;

    @Column(name = "c_Salary")
    @NotEmpty(message = "khong duoc bo trong")
    private String Salary;
}
