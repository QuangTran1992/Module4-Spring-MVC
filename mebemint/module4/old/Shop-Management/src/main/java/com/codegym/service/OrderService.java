package com.codegym.service;


import com.codegym.model.Order;
import com.codegym.model.shopDTO.OrderResult;
import com.codegym.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;


    @Override
    public Iterable<Order> findAll() {
      return  null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderResult> getOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResult> orderResults = new ArrayList<>();
        orders.forEach((item->{
            OrderResult order = new OrderResult();
            order.setId(item.getId());
            order.setShopName(item.getShop().getNameShop());

            order.setCustomerName(item.getCustomerName());
            order.setStatus(item.getStatus());

            order.setAddress(item.getAddress());
            order.setDeliverAt(item.getDeliverAt());

            order.setProduct(item.getProduct());
            order.setMessage(item.getMessage());

            order.setTotal(item.getDeliverFee().add(item.getProductPrice()));

            orderResults.add(order);
        }));
        return  orderResults;
    }
}
