package com.example.demo.dtos;

import java.time.LocalDateTime;

import com.example.demo.entities.Order;
import com.example.demo.entities.StatusPedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class OrderDTO {
    private Long id;
    @PastOrPresent(message = "A data do pedido não pode ser futura")
    private LocalDateTime dataPedido;
    @NotNull(message = "O status do pedido é obrigatório")
    private StatusPedido status;
    private Double total;
    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clientId;

    public OrderDTO() {

    }

    public OrderDTO(Long id, LocalDateTime dataPedido, StatusPedido status, Double total, Long clientId) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.status = status;
        this.total = total;
        this.clientId = clientId;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.dataPedido = entity.getDataPedido();
        this.status = entity.getStatus();
        this.total = entity.getTotal();
        this.clientId = entity.getClient().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
