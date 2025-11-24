package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
