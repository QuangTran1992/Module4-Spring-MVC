package com.codegym.repository;

import com.codegym.model.Shop;
import com.codegym.model.shopDTO.OrderResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends JpaRepository<Shop, Long> {

    @Query(value = "select o.id,o.customerName,o.status,o.phone,o.address,o.deliverAt,o.product,o.message,o.total" +
            " from orders o" +
            " inner join shops s" +
            " on s.shop_id = o.shop_id",nativeQuery = true)
    Iterable<OrderResult> findAllOrders();
}
