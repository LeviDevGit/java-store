package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.OrderProduct;
import com.example.demo.services.OrderProductService;

@RestController
@RequestMapping(value = "/order-products")
public class OrderProductController {

    @Autowired
    public OrderProductService orderProductService;

    @GetMapping
    public List<OrderProduct> findAllOrderProducts() {
        return orderProductService.findAllOrderProducts();
    }
}
