package com.codegym.repository;

import com.codegym.model.Order;
import com.codegym.model.dto.OrderDTO;
import com.codegym.model.dto.ShopDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<Order , Long> {


    @Query(value = "select o.id,o.customerName,o.status,o.phone,o.address,o.deliverAt,o.product,o.message,o.total\n" +
            " from orders o\n" +
            " inner join shops s \n" +
            " on s.shop_id = o.shop_id",nativeQuery = true)
     Iterable<OrderDTO> findAllOrders();
}
