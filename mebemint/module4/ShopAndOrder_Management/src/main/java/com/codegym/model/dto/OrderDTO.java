package com.codegym.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id_order;

    private String customerName;

    private String status;

    private String phone;

    private String address;

    private Date deliverDay;

    private String product;

    private String message;

    private BigDecimal total;



}
