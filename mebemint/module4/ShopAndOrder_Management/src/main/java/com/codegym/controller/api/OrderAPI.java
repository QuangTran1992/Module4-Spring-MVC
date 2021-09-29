package com.codegym.controller.api;


import com.codegym.model.Order;
import com.codegym.model.dto.OrderDTO;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderAPI {

    @Autowired
    public IOrderService orderService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            Iterable<OrderDTO> orders = orderService.findAllOrders();
            if (((List)orders).isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
