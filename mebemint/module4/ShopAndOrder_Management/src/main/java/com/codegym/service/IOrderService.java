package com.codegym.service;

import com.codegym.IGeneralService;
import com.codegym.model.Order;
import com.codegym.model.dto.OrderDTO;

public interface IOrderService extends IGeneralService<Order> {

    public Iterable<OrderDTO> findAllOrders();
}
