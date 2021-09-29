package com.codegym.repository.model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false,length = 200)
    private String fullName;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @Column(nullable = false, unique = true,length = 255)
    private String email;

    @Column(nullable = false,length = 128)
    private String passwordHash;

    private String address;

    @Column(nullable = false)
    private UserStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private Date createdAt;

    private Date modifyAt;


    @OneToMany(targetEntity = Order.class , fetch = FetchType.EAGER)
    private List<Order> orders;

}
