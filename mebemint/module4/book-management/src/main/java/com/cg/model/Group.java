package com.cg.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Khong duoc bo trong")
    private String nhomSach;

    @NotEmpty(message = "Khong duoc bo trong")
    @OneToMany(targetEntity = Book.class, fetch = FetchType.EAGER)
    private Set<Book> books;
}
