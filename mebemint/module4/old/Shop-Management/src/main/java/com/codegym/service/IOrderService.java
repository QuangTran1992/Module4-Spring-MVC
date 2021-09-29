package com.codegym.service;

import com.codegym.IGeneralService;
import com.codegym.model.Order;
import com.codegym.model.shopDTO.OrderResult;

import java.util.List;

public interface IOrderService extends IGeneralService<Order> {

    List<OrderResult> getOrders();
}
