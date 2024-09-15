package com.example.proj1.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.proj1.validation.notEmptyList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PedidoDTO {
    @NotBlank(message = "Informe o cliente")
    private Integer cliente;
    @NotNull(message = "Total invalido")
    private BigDecimal total;
    @notEmptyList(m = "Um pedido precisa ter pelo menos um item")
    private List<ItemPedidoDTO> itens;

    // Getters and Setters
    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
