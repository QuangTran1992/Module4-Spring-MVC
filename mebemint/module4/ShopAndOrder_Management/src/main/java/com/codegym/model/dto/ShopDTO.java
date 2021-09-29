package com.codegym.model.dto;

import com.codegym.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShopDTO {

    private Long id_order;

    private String nameShop;

    private Long idOrder;

    private String product;


}
