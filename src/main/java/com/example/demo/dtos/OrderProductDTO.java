package com.example.demo.dtos;

import com.example.demo.entities.OrderProduct;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class OrderProductDTO {
    private Long id;
    @NotNull(message = "O pedido é obrigatório")
    private Long orderId;
    @NotNull(message = "O produto é obrigatório")
    private Long productId;
    @NotNull(message = "Quantidade é obrigatório")
    @PositiveOrZero(message = "Quantidade não pode ser negativo")
    private Integer quantidade;

    // public Double getSubTotal() {
    // return product.getPreco() * quantidade;
    // }

    public OrderProductDTO() {

    }

    public OrderProductDTO(Long id, Long orderId, Long productId, Integer quantidade) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantidade = quantidade;
    }

    public OrderProductDTO(OrderProduct entity) {
        this.id = entity.getId();
        this.orderId = entity.getOrder().getId();
        this.productId = entity.getProduct().getId();
        this.quantidade = entity.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
