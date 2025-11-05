package com.felipeporceli.application.service;

import com.felipeporceli.application.entities.Order;
import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    public Order findOrderById (Integer id) {
        Optional<Order> order = repository.findById(id);
        return order.get();
    }

}
