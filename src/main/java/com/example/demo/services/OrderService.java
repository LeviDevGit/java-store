package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dtos.OrderDTO;
import com.example.demo.entities.Client;
import com.example.demo.entities.Order;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Order> findAllOrders() {
        List<Order> result = orderRepository.findAll();
        return result;
    }

    @Transactional
    public Order createOrder(OrderDTO body) {
        Client client = clientRepository.findById(body.getClientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Order order = new Order();
        order.setDataPedido(body.getDataPedido());
        order.setStatus(body.getStatus());
        order.setTotal(body.getTotal());
        order.setClient(client);

        return orderRepository.save(order);
    }
}
