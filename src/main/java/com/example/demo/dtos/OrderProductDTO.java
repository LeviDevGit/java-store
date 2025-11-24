package com.example.demo.dtos;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderProduct;
import com.example.demo.entities.Product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class OrderProductDTO {
    private Long id;
    @NotNull(message = "O pedido é obrigatório")
    private Order order;
    @NotNull(message = "O produto é obrigatório")
    private Product product;
    @NotNull(message = "Quantidade é obrigatório")
    @PositiveOrZero(message = "Quantidade não pode ser negativo")
    private Integer quantidade;

    public Double getSubTotal() {
        return product.getPreco() * quantidade;
    }

    public OrderProductDTO() {

    }

    public OrderProductDTO(Long id, Order order, Product product, Integer quantidade) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantidade = quantidade;
    }

    public OrderProductDTO(OrderProduct entity) {
        this.id = entity.getId();
        this.order = entity.getOrder();
        this.product = entity.getProduct();
        this.quantidade = entity.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
