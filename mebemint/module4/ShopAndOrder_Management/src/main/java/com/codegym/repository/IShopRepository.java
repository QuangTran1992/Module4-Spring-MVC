package com.codegym.repository;

import com.codegym.model.Shop;

import com.codegym.model.dto.ShopDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IShopRepository extends JpaRepository<Shop , Long> {


    @Query(value =
            "(select s.Shop_Name, o.id, o.product from shops s, orders o WHERE s.shop_id = o.shop_id  ",nativeQuery = true)
    Iterable<ShopDTO> findAllOrders();
}
