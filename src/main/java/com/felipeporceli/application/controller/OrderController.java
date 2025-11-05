/* PT-BR Classe para manipular e lidar com requisições web relacionadas a entidade "User" */
/* EN:US Class for manipulating and handling web requests related to the "User" entity. */
package com.felipeporceli.application.controller;

import com.felipeporceli.application.entities.Order;
import com.felipeporceli.application.entities.User;
import com.felipeporceli.application.service.OrderService;
import com.felipeporceli.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = service.findAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Integer id) {
        Order obj = service.findOrderById(id);
        return ResponseEntity.ok().body(obj);
    }

}
