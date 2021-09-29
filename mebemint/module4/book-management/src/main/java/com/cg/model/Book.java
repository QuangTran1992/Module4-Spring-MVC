package com.cg.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Khong duoc bo trong")
    @ManyToOne
    private Group group;

    @NotEmpty(message = "Khong duoc bo trong")
    @Column( nullable = false)
    private String tenSach;

    @NotEmpty(message = "Khong duoc bo trong")
    @Column( nullable = false)
    private String tacGia;

    @NotEmpty(message = "Khong duoc bo trong")
    @Column( nullable = false)
    private String nhaXuatBan;

    @NotEmpty(message = "Khong duoc bo trong")
    @Column( nullable = false)
    private String namXuatBan;

    @NotNull(message = "Khong duoc bo trong")
    @Column(nullable= false)
    private Long soLuongXuatBan;



}
