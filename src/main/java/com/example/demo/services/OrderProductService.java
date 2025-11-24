package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.OrderProduct;
import com.example.demo.repositories.OrderProductRepository;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Transactional(readOnly = true)
    public List<OrderProduct> findAllOrderProducts() {
        List<OrderProduct> result = orderProductRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public OrderProduct getByOrderProductId(Long id) {
        OrderProduct result = orderProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return result;
    }

    @Transactional
    public void deleteOrderProduct(Long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderProductRepository.delete(orderProduct);
    }
}
