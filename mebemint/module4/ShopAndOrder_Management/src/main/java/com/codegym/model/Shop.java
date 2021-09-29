package com.codegym.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "shops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    @Column (name = "Shop_Name" )
    @NotNull
    private String nameShop;

    @OneToMany(mappedBy = "shop",fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE},targetEntity = Order.class)
    @JsonIgnore
    private List<Order> orders;



    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", ShopName='" + nameShop + '\'' +
                ", orders=" + orders +
                '}';
    }

}
