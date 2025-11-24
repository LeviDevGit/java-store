package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dtos.OrderProductDTO;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderProduct;
import com.example.demo.entities.Product;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

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
    public OrderProduct createOrderProduct(OrderProductDTO body) {
        Order order = orderRepository.findById(body.getOrderId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Product product = productRepository.findById(body.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        OrderProduct entity = new OrderProduct();
        entity.setOrder(order);
        entity.setProduct(product);
        entity.setQuantidade(body.getQuantidade());

        return orderProductRepository.save(entity);
    }

    @Transactional
    public void deleteOrderProduct(Long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderProductRepository.delete(orderProduct);
    }
}
