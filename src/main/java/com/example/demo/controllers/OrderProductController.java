package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.OrderProductDTO;
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

    @GetMapping(value = "/{id}")
    public OrderProduct findOrderProductById(@PathVariable Long id) {
        OrderProduct orderProduct = orderProductService.getByOrderProductId(id);
        return orderProduct;
    }

    @PostMapping
    public OrderProduct createOrderProduct(@RequestBody OrderProductDTO body) {
        OrderProduct orderProduct = orderProductService.createOrderProduct(body);
        return orderProduct;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrderProduct(@PathVariable Long id) {
        orderProductService.deleteOrderProduct(id);
    }
}