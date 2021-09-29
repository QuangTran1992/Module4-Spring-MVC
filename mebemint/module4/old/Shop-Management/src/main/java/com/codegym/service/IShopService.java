package com.codegym.service;

import com.codegym.IGeneralService;
import com.codegym.model.Shop;
import com.codegym.model.shopDTO.OrderResult;

public interface IShopService extends IGeneralService<Shop> {
    Iterable<OrderResult> findAllOrders();
}
