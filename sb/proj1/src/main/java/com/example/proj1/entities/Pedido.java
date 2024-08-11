package com.example.proj1.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private LocalDate data;
    private Cliente cliente;
    private Integer id;
    private BigDecimal total;
    
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    

    
}
