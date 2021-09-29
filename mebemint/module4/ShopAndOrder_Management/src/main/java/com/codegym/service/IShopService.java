package com.codegym.service;

import com.codegym.IGeneralService;
import com.codegym.model.Shop;
import com.codegym.model.dto.IShopDTO;
import com.codegym.model.dto.ShopDTO;

public interface IShopService extends IGeneralService<Shop> {

    Iterable<ShopDTO> findAllByOrders();
}
