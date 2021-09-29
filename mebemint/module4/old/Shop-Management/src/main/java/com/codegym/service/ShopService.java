package com.codegym.service;

import com.codegym.model.Shop;
import com.codegym.model.shopDTO.OrderResult;
import com.codegym.repository.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ShopService implements IShopService{
    @Autowired
    private IShopRepository shopRepository;


    @Override
    public Iterable<Shop> findAll() {
return null;
    }

    @Override
    public Optional<Shop> findById(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }


    @Override
    public void remove(Long id) {
        shopRepository.deleteById(id);

    }

    @Override
    public Iterable<OrderResult> findAllOrders() {
        return shopRepository.findAllOrders();
    }
}
